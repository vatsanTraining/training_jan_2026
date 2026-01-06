package com.training.ifaces;
import java.util.*;
public interface CrudOperation<T> {

	
	boolean add(T t);
	Collection<T> findAll();
	boolean remove(T t);
	
}
