package dao.impl;

import dao.TeamDao;
import model.Team;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public class TeamDaoImpl extends NamedParameterJdbcDaoSupport implements TeamDao {
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

	@Override
	public Team getTeam(Integer teamId) throws DataAccessException {
		final String sql = "SELECT team_id, name FROM team WHERE team_id =:teamId";
		SqlParameterSource parameterSource = new MapSqlParameterSource("teamId", teamId);
		return getNamedParameterJdbcTemplate().query(sql, parameterSource, new TeamResultSetExtractor());
	}

	protected class TeamResultSetExtractor implements ResultSetExtractor<Team> {

		@Override
		public Team extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()){
				Team team = new Team();
				team.setId(rs.getInt("team_id"));
				team.setName(rs.getString("name"));
				return team;
			} else {
				return null;
			}
		}
	}
}
