package sample1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by junyoung on 2017. 7. 2..
 */
public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean{

	private String greeting;
	private String name;
	private String beanName;
	private BeanFactory beanFactory;

	public MessageBeanImpl(){
		System.out.println("1. Bean 의 생성자 실행");
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("2. 설정 메서드 실행");
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("3. Bean 이름 지정");
		this.beanName = beanName;
		System.out.println(" -> " + beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("4. BeanFactory 지정");
		this.beanFactory = beanFactory;
		System.out.println(" -> " + beanFactory.getClass());
	}

	public void init(){
		System.out.println("7. 초기화 메서드 실행");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("종료");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6. 프로퍼티 지정 완료");
	}

	public void sayHello(){
		System.out.println(greeting + beanName + "!");
	}

}
