package dao;

import model.Team;
import org.springframework.dao.DataAccessException;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public interface TeamDao {
	java.util.List<Team> getTeamList() throws DataAccessException;
	Team getTeam(Integer teamId) throws DataAccessException;
}
