package sample3;

/**
 * Created by junyoung on 2017. 7. 2..
 */
public class MessageBeanEn implements MessageBean{
	@Override
	public void sayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}
}
