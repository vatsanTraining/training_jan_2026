package com.training.ifaces;
import java.util.*;
public interface CrudOperation<T> {

	/*
	 * Create a User Defined Exception DuplicateElement exception
	 *  add it as a throws clause of add Method
	 *  throw the exception from service layer
	 *  handle it in the main method
	 *  
	 *  Intention is to use throws, throw and try-catch block
	 *  and creating a custom exception
	 */
	
	boolean add(T t) throws DuplicateElementException;
	Collection<T> findAll();
	boolean remove(T t);
	
}


