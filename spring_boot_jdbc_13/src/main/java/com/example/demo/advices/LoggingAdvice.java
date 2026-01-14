package com.example.demo.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

	
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	

	@Before("execution(* com.example.demo.ifaces.*.*(..))")
	public void logBefore(JoinPoint jp) {   //joinpoint
		 
		
		
		//advice
		
		logger.info(jp.getSignature().getName() + "Called **********");
		
		
	}
}
