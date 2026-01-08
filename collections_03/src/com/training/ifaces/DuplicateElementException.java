package com.training.ifaces;

public class DuplicateElementException extends Exception {

	private static final long serialVersionUID = 1L;

	
	private String message;


	public DuplicateElementException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String getMessage() {

		return "ERR-101 -"+ this.message;
	}
	
	
	
}
