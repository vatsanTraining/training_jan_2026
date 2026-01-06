package com.example.ifaces;

@FunctionalInterface
public interface Function<T,R> {

	
	R calculate(T t);
	
	default  double apply() {
		return 1200.00;
	}
}


