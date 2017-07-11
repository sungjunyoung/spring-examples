package user.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import user.dao.*;
import user.domain.User;

import java.sql.SQLException;

/**
 * Created by junyoung on 2017. 7. 8..
 */
public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//UserDao dao = new DaoFactory().userDao();
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
//		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setId("test12");
		user.setName("성준영");
		user.setPassword("{password}");

		dao.add(user);

		System.out.println(user.getId() + " 등록 성공");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());

		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
	}
}
