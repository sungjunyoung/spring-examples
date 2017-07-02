package sample3;

/**
 * Created by junyoung on 2017. 7. 2..
 */
public class MessageBeanKo implements MessageBean{
	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요, " + name + "!");
	}
}
