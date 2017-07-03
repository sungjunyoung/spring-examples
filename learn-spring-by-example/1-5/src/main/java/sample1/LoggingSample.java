package sample1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public class LoggingSample {
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);

		System.out.println("[LOG] METHOD: " + methodName + " is calling...");
		Object rtnObj = pjp.proceed();

		sw.stop();

		System.out.println("[LOG] METHOD: " + methodName + " was called.");
		System.out.println("[LOG] 처리시간: " + sw.getTotalTimeMillis() / 1000 + "초");

		return rtnObj;
	}
}
