package dao.impl;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by junyoung on 2017. 7. 8..
 */
public class DeletePlayer extends SqlUpdate{

	private static String SQL_DELETE_PLAYER = "DELETE FROM player WHERE player_id = ?";

	public DeletePlayer(DataSource ds) {
		super(ds, SQL_DELETE_PLAYER);
		super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
		compile();
	}
}
