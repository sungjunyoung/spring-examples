package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**
 * Created by junyoung on 2017. 7. 2..
 */
public class LoggingAdvice implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();

		sw.start(methodName);

		System.out.println("[LOG] METHOD: " + methodName + " is calling.");
		Object rtnObj = invocation.proceed();

		sw.stop();


		System.out.println("[LOG] METHOD: " + methodName + " was called.");
		System.out.println("[LOG] 처리시간: " + sw.getTotalTimeMillis() / 1000 + " 초");

		return rtnObj;
	}
}
