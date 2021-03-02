package com.company.yedam.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class ExpectTimeAspect {
	@Pointcut("execution(* com.company.yedam..*Impl.*One(..))")
	public void getpointcut() {
	}

	@Around("getpointcut()")
	public Object measure(ProceedingJoinPoint pjp) {
		System.out.println("[around] before ");
		long start = System.nanoTime(); // current time = nanotime
		Object result = null;
		try {
			result = pjp.proceed(); // service 호출
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			long finish = System.nanoTime();
			System.out.println("[around] after 실행시간: " + (finish - start));
		}
		return result;
	}
}
