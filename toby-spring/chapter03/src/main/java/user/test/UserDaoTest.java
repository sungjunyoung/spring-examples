package user.test;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import user.dao.JdbcContext;
import user.dao.UserDao;
import user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.runner.RunWith;

import javax.sql.DataSource;

/**
 * Created by junyoung on 2017. 7. 8..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoTest {

	@Autowired
	private ApplicationContext context;
	private UserDao dao;
	private User user1;
	private User user2;
	private User user3;

	@Before
	public void setUp(){

		dao = new UserDao();
		DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/spring_testdb", "<user>","<password>", true);
		dao.setDataSource(dataSource);

		this.user1 = new User("1", "성준영", "tjdwnsdud");
		this.user2 = new User("2", "김민호", "rlaalsgh");
		this.user3 = new User("3", "조주영", "whwndud");
	}

	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {


		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));

		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));

		User userget2 = dao.get(user2.getId());
		assertThat(userget2.getName(), is(user2.getName()));
		assertThat(userget2.getPassword(), is(user2.getPassword()));
	}

	@Test
	public void count() throws SQLException, ClassNotFoundException {

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.add(user1);
		assertThat(dao.getCount(), is(1));

		dao.add(user2);
		assertThat(dao.getCount(), is(2));

		dao.add(user3);
		assertThat(dao.getCount(), is(3));
	}

	@Test(expected=EmptyResultDataAccessException.class)
	public void getuserFailture() throws SQLException, ClassNotFoundException {
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.get("unknown_id");
	}

	@Test
	public void getAll() throws SQLException, ClassNotFoundException {
		dao.deleteAll();
		dao.add(user1);
		List<User> users = dao.getAll();
		assertThat(users.size(), is(1));
		checkSameUser(user1, users.get(0));

		dao.add(user2);
		users.add(user2);
		assertThat(users.size(), is(2));
		checkSameUser(user2, users.get(1));

		dao.deleteAll();
		dao.add(user1);
		dao.add(user2);
		dao.add(user3);
		List<User> users1 = dao.getAll();
		assertThat(users1.size(), is(3));
		checkSameUser(user1, users1.get(0));
		checkSameUser(user2, users1.get(1));
		checkSameUser(user3, users1.get(2));

		dao.deleteAll();
		List<User> users2 = dao.getAll();
		assertThat(users2.size(), is(0));
	}

	private void checkSameUser(User user1, User user2){
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));
	}
}
