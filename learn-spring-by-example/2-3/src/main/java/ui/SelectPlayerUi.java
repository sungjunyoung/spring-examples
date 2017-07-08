package ui;

import dao.PlayerDao;
import model.Player;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by junyoung on 2017. 7. 8..
 */
public class SelectPlayerUi extends AbstractUiTemplate {

	private PlayerDao playerDao;
	private UpdatePlayerUi updatePlayerUi;
	private DeletePlayerUi deletePlayerUi;

	public void setPlayerDao(PlayerDao dao) {
		this.playerDao = dao;
	}

	public void setUpdatePlayerUi(UpdatePlayerUi ui) {
		this.updatePlayerUi = ui;
	}

	public void setDeletePlayerUi(DeletePlayerUi ui) {
		this.deletePlayerUi = ui;
	}

	public void show() {
		showHeader();
		Integer teamId = getTeamId();
		showPlayerList(this.playerDao.getPlayerList(teamId));
		System.out.println("Enter 키를 눌러주세요.");
		getInputedString();
		super.show();
	}

	protected Integer getTeamId() {
		System.out.println("목록을 표시하고 싶은 팀의 ID 를 입력한 후 Enter 키를 눌러주세요.");
		String teamId = getInputedString();

		if (StringUtils.isNotEmpty(teamId) && StringUtils.isNumeric(teamId)) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("[선수명단] -> [선수목록]");
		System.out.println("");
	}

	protected void showPlayerList(List<Player> playerList) {
		System.out.println("--------------------");
		System.out.println("[선수명단] -> [선수목록]");
		if (!playerList.isEmpty()) {
			Player player = playerList.get(0);
			System.out.printf("팀명: %s%n", player.getTeam().getName());
		}
		System.out.println("ID    이름");
		for (Player player : playerList) {
			System.out.printf("%d  %s%n", player.getId(), player.getName());
		}
	}

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
				updatePlayerUi.show();
				break;
			case 2:
				deletePlayerUi.show();
				break;
			default:
				return;
		}
	}

	@Override
	protected void showMenu() {
		showHeader();
		System.out.println("1. 선수 갱신");
		System.out.println("2. 선수 삭제");
		System.out.println("3. 메뉴로 돌아가기");
		System.out.println("");
		System.out.println("번호를 입력한 뒤 Enter 키를 눌러주세요.");
	}
}
