package dao;

import model.Player;
import org.springframework.dao.DataAccessException;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException;
}
