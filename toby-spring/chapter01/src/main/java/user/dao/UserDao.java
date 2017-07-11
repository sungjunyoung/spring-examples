package user.dao;

import user.domain.User;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by junyoung on 2017. 7. 8..
 */
public class UserDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = dataSource.getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection c = dataSource.getConnection();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return user;

	}
}
