package com.training.ifaces;

import com.training.model.*;

public interface CrudOperation {

	String MESSAGE ="First Example";
	
	boolean add(Player player);
	Player[] findAll();
}
