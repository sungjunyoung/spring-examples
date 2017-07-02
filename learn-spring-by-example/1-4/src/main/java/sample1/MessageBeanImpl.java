package sample1;

/**
 * Created by junyoung on 2017. 7. 2..
 */
public class MessageBeanImpl implements MessageBean{

	private String name;

	@Override
	public void sayHello() {
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e){}

		System.out.println("Hello, " + name + "!");
	}

	public void setName(String name) {
		this.name = name;
	}
}
