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

	    long startTime = System.nanoTime();


	Object obj=joinPoint.proceed(); 

    long endTime = System.nanoTime();
    
    long timeTaken = endTime - startTime;

    double seconds = (double)timeTaken / 1_000_000_000.0;

	
    String message = """
    	    Method => %s 
    	    completed within :=> %f Seconds
    	    """.formatted(joinPoint.getSignature().getName(), seconds);

    	System.out.println(message);

	return obj;
	
	}
	
	@Around("execution(* com.example.demo.services.*.*(int))") 
	 
	public Object discount(ProceedingJoinPoint joinPoint) throws Throwable { 


	Object obj=joinPoint.proceed(); 

	if(obj instanceof Invoice) {
		
	Invoice inv = (Invoice)obj;
	
	
	double discount =inv.amount()-inv.amount()*.10;
	
	System.out.println("RETURN Value :#######>>>>"+ discount);
	
    Invoice discountedInv = new Invoice(inv.invoiceNumber(),inv.customerName(),inv.invoiceDate() ,discount);

	return discountedInv;
	}
	return obj;
	
	}


}
