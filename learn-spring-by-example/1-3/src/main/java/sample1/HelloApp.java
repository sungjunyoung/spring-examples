package sample1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * Created by junyoung on 2017. 7. 2..
 */
public class HelloApp implements BeanPostProcessor{
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.sayHello();
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("5. 초기화 전 Bean 에 대한 처리 실행");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("8. 초기화 후 Bean 에 대한 처리 실행");
		return bean;
	}
}
