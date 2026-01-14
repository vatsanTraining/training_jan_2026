package com.example.ifaces;

import java.util.List;

public interface MyDao<T> {

	
	boolean add(T t);
	List<T> findAll();
	T findById(int id) throws RuntimeException;
}
