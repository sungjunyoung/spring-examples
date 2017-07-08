package dao;

import model.Player;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException;
	List<Player> getPlayerList(Integer teamId) throws DataAccessException;
	Player getPlayer(Integer id) throws DataAccessException;

	void deletePlayer(Player player) throws DataAccessException;
	void updatePlayer(Player player) throws DataAccessException;
}
