package com.lubby.log;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *     @author Lubby
 *     @date 2015年3月25日  下午10:33:37
 *
 */

//@Aspect
@Component
public class LogIntercepter {
//	@Before("execution(* com.lubby.service.impl.*.*(..))")
	public void startLog(){
		System.out.println("starting time:" + new Date());
	}
	
//	@After("execution(* com.lubby.service.impl.*.*(..))")
	public void endLog(){
		System.out.println("ending time:" + new Date());
	}
//	@Around("execution(* com.lubby.service.impl.*.*(..))")
	public Object round(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("starting time:" + new Date());
			Object object =	 pjp.proceed();
		System.out.println("ending time:" + new Date());

			return object;

	}

}
