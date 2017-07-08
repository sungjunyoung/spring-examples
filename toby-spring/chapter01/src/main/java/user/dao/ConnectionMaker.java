package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by junyoung on 2017. 7. 8..
 */
public interface ConnectionMaker {
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
