package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

//부수적인 관심사만 모아놓은 클래스
//이런 클래스를 advice class라고 한다. 

public class LoggingAdvice {
	private Log log = LogFactory.getLog(getClass());
	
	public void logPush(ProceedingJoinPoint pjp) throws Throwable{
        log.info("\ncheck...before logging...");

        Object ret=pjp.proceed();//target으로 위빙되는 시점
        System.out.println("target method return..."+ret);
	}
}