package ui;

import dao.PlayerDao;
import dao.impl.PlayerDaoImpl;
import model.Player;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by junyoung on 2017. 7. 8..
 */
public class DeletePlayerUi extends AbstractUi {

	private PlayerDao playerDao;

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public void show() {
		showMenu();
		String id = getInputedString();
		if (StringUtils.isEmpty(id)) {
			return;
		} else if (UiUtils.isNumeric(id, "선수ID")) {
			Player player = this.playerDao.getPlayer(Integer.valueOf(id));
			if (player == null) {
				System.out.printf("입력한 선수 ID '%s'인 선수는 존재하지 않습니다.%n", id);
			 	show();
			} else {
				this.playerDao.deletePlayer(player);
				System.out.printf("선수 ID '%s'선수를 삭제합니다.%n",id);
			}
		} else {
			show();
		}
	}

	protected void showMenu(){
		System.out.println("--------------------");
		System.out.println("[선수명단] -> [선수삭제]");
		System.out.println("");
		System.out.println("선수ID 를 입력한 후 Enter 를 눌러주세요.");
		System.out.println("아무것도 입력하지 않고 Enter 를 눌르면 메뉴로 돌아갑니다.");
	}

}
