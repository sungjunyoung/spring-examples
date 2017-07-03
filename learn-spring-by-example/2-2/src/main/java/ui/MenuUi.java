package ui;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public class MenuUi extends AbstractUiTemplate {

	private SelectTeamUi selectTeamUi;
	private InsertPlayerUi insertPlayerUi;

	@Override
	protected int getMaxMenuNumber() {
		return 3;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch (number) {
			case 1:
				System.out.println("종료되었습니다.");
				System.exit(0);
			case 2:
				this.selectTeamUi.show();
				break;
			case 3:
				this.insertPlayerUi.show();
				break;
		}
	}

	@Override
	protected void showMenu() {
		System.out.println("--------------------");
		System.out.println("[선수명단] -> [메뉴]");
		System.out.println("1. 종료");
		System.out.println("2. 팀 목록");
		System.out.println("3. 선수 추가");
		System.out.println("번호를 입력한 후 Enter 키를 눌러주세요.");
	}

	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
		this.insertPlayerUi = insertPlayerUi;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MenuUi menuUi = context.getBean(MenuUi.class);
		while (true) {
			menuUi.show();
		}
	}

}
