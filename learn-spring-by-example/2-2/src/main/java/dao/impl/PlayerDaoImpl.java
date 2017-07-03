package dao.impl;

import dao.PlayerDao;
import model.Player;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao{

	private SimpleJdbcInsert insertPlayer;

	protected void initDao() throws Exception {
		this.insertPlayer = new SimpleJdbcInsert(getDataSource())
						.withTableName("player")
						.usingGeneratedKeyColumns("player_id");
	}

	@Override
	public void insertPlayer(Player player) throws DataAccessException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", player.getName());
		parameters.put("team_id", player.getTeam().getId());

		Number newId = this.insertPlayer.executeAndReturnKey(parameters);
		player.setId(newId.intValue());
	}
}
