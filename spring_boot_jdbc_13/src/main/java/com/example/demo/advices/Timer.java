package com.example.demo.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Invoice;

@Aspect
@Component
public class Timer {

	
	
	// use @Around advice on a method use ProceedingJoinPoint as a argument

	// show the amount of time taken to complete a method
	
	// if findByid method is called the returned object amount should be discounted by 10%
	
	
	@Around("execution(* com.example.demo.services.*.*(..))") 
	 
	public Object iamAround(ProceedingJoinPoint joinPoint) throws Throwable { 

	System.out.println("Method Called $$$$$$$$$" +joinPoint.getSignature().getName()); 

	Object obj=joinPoint.proceed(); 

	
	
	return obj;
	
	}
	
	@Around("execution(* com.example.demo.services.*.*(int))") 
	 
	public Object discount(ProceedingJoinPoint joinPoint) throws Throwable { 


	Object obj=joinPoint.proceed(); 

	Invoice inv = (Invoice)obj;
	
	var discount =inv.amount()*.10;
	
	System.out.println("RETURN Value :#######>>>>"+ discount);
	
	
	return obj;
	
	}


}
