package dao.impl;

import dao.PlayerDao;
import model.Player;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao{

	private SimpleJdbcInsert insertPlayer;
	private PlayerListQuery playerListQuery;
	private PlayerQuery playerQuery;

	private DeletePlayer deletePlayer;
	private UpdatePlayer updatePlayer;

	protected void initDao() throws Exception {
		this.insertPlayer = new SimpleJdbcInsert(getDataSource())
						.withTableName("player")
						.usingGeneratedKeyColumns("player_id");
		this.playerListQuery = new PlayerListQuery(getDataSource());
		this.playerQuery = new PlayerQuery(getDataSource());
		this.deletePlayer = new DeletePlayer(getDataSource());
		this.updatePlayer = new UpdatePlayer(getDataSource());
	}

	@Override
	public void insertPlayer(Player player) throws DataAccessException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", player.getName());
		parameters.put("team_id", player.getTeam().getId());

		Number newId = this.insertPlayer.executeAndReturnKey(parameters);
		player.setId(newId.intValue());
	}

	@Override
	public List<Player> getPlayerList(Integer teamId) throws DataAccessException {
		return this.playerListQuery.execute(teamId);
	}

	@Override
	public Player getPlayer(Integer id) throws DataAccessException {
		return this.playerQuery.findObject(id);
	}

	@Override
	public void deletePlayer(Player player) throws DataAccessException {
		this.deletePlayer.update(player.getId());
	}

	@Override
	public void updatePlayer(Player player) throws DataAccessException {
		this.updatePlayer.update(player.getName(), player.getTeam().getId(), player.getId());
	}
}
