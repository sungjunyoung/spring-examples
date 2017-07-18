package user.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import user.domain.User;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by junyoung on 2017. 7. 8..
 */
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<User> userMapper = new RowMapper<User>(){

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	};

	public void add(User user) throws ClassNotFoundException, SQLException {
		this.jdbcTemplate.update("INSERT INTO users(id, name, password) values(?,?,?)", user.getId(), user.getName(), user.getPassword());
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id},this.userMapper);
	}


	public void deleteAll() throws SQLException {
		this.jdbcTemplate.update("DELETE FROM users");
	}

	public int getCount() throws SQLException {
//		return this.jdbcTemplate.query(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				return con.prepareStatement("SELECT count(*) FROM users");
//			}
//		}, new ResultSetExtractor<Integer>() {
//			@Override
//			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
//				rs.next();
//				return rs.getInt(1);
//			}
//		});
		return this.jdbcTemplate.queryForInt("SELECT count(*) FROM users");
	}

	public java.util.List<User> getAll() {
		return this.jdbcTemplate.query("SELECT * FROM users ORDER BY id",this.userMapper);
	}
}
