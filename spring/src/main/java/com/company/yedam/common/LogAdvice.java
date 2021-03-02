package com.company.yedam.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.company.yedam..*Impl.*(..))")
	public void allpointcut() {}		//수동 방식의 id 값을 의미
	
	@Before("allpointcut()")			//id값이 method이기에 ()까지
	public void printLog(JoinPoint jp) {
		// method name
		String name = jp.getSignature().getName();
		// 매개변수
		Object[] args = jp.getArgs();

		System.out.println("[공통로그] before 적용\n" + name + "===" + (args != null && args.length > 0 ? args[0] : ""));
	}

}// end of class
