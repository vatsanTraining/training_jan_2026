package com.example.demo;

import com.example.demo.model.AutoPolicy;
import com.example.demo.model.HomePolicy;
import com.example.demo.model.InsurancePolicy;

/**
 * Hello world!
 */
public class App {
	
	
	public static InsurancePolicy  getPolicy(int key) {
		
		switch (key) {
		case 1:
			return new AutoPolicy();
		case 2:
			return new HomePolicy();
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}
	
	
public static InsurancePolicy  useSwitchExpression(int key) {
		
	 InsurancePolicy policy   =switch (key) {
	case 1: {
		
		yield new AutoPolicy();
	}
	case 2: {
		yield new HomePolicy();
	  }
	default:
		throw new IllegalArgumentException("Unexpected value: " + key);
	 };
	
	 return policy;
		}
	

	public static void calculate(InsurancePolicy policy) {
		
		System.out.println(policy.calculatePremium());
			
	}
    public static void main(String[] args) {
        
        InsurancePolicy policy = getPolicy(1);
        
        calculate(policy);
        
        
        InsurancePolicy anotherPolicy = useSwitchExpression(2);
        
        calculate(anotherPolicy);
        
    }
}
