package dao.impl;

import dao.TeamDao;
import model.Team;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {
	@Override
	public List<Team> getTeamList() throws DataAccessException {
		RowMapper<Team> rowMapper = new TeamRowMapper();

		return getJdbcTemplate().query("SELECT team_id, name FROM team", rowMapper);
	}

	protected class TeamRowMapper implements RowMapper<Team> {
		private List<Team> teamList = new ArrayList<Team>();

		public List<Team> getResults(){
			return teamList;
		}

		@Override
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("name"));
			return team;
		}
	}
}
