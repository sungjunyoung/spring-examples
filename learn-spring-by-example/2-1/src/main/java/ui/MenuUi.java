package ui;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public class MenuUi extends AbstractUiTemplate{

	private SelectTeamUi selectTeamUi;

	@Override
	protected int getMaxMenuNumber() {
		return 2;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch(number){
			case 1:
				System.out.println("종료되었습니다.");
				System.exit(0);
			case 2:
				this.selectTeamUi.show();
				break;
		}
	}

	@Override
	protected void showMenu() {
		System.out.println("--------------------");
		System.out.println("[선수명단] -> [메뉴]");
		System.out.println("1. 종료");
		System.out.println("2. 팀 목록");
		System.out.println("번호를 입력한 후 Enter 키를 눌러주세요.");
	}

	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MenuUi menuUi = context.getBean(MenuUi.class);
		while(true){
			menuUi.show();
		}
	}
}
