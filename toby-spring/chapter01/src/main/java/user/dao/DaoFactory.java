package user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by junyoung on 2017. 7. 8..
 */

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao(){
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/springbook");
		dataSource.setUsername("{user}");
		dataSource.setPassword("{password}");

		return dataSource;
	}
}
