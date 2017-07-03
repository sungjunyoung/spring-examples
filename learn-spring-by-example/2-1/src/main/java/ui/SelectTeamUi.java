package ui;

import java.util.List;

import model.Team;
import dao.TeamDao;

public class SelectTeamUi extends AbstractUi {

    private TeamDao teamDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void show() {
        showTeamList(this.teamDao.getTeamList());
        System.out.println("Enter 를 누르면 메뉴로 나갑니다.");
        getInputedString();
    }

    protected void showTeamList(List<Team> teamList) {
        System.out.println("--------------------");
        System.out.println("[선수명단] -> [팀 목록]");
        System.out.println("ID    이름");
        for (Team team : teamList) {
        	System.out.printf("%d  %s%n", team.getId(), team.getName());
		}
    }
}
