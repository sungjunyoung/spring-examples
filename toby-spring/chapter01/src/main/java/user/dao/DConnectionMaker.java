package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by junyoung on 2017. 7. 8..
 */
public class DConnectionMaker implements ConnectionMaker {
	@Override
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "{user}", "{password}");
		return c;

	}
}
