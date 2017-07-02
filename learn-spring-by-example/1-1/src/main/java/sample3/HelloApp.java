package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by junyoung on 2017. 7. 2..
 */


public class HelloApp {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		MessageBean bean = (MessageBean) context.getBean("messageBean", MessageBean.class);
		bean.sayHello("성준영");
	}
}
