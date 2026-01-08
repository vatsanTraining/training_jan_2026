package com.training.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.training.ifaces.CrudOperation;
import com.training.ifaces.DuplicateElementException;
import com.training.model.Player;

public class PlayerImpl implements CrudOperation<Player> {

	private List<Player> players;  
	
	
	public PlayerImpl() {
		super();
		
		this.players = new ArrayList<>();
	}

	@Override
	public boolean add(Player obj) throws DuplicateElementException {
		
		if(true) {
			 throw new DuplicateElementException("Element with given id already Exisit");

		}  
		
		return this.players.add(obj);
		
	  
	}   

	@Override
	public Collection<Player> findAll() {
		return this.players;
	}

	@Override
	public boolean remove(Player t) {

		return this.players.remove(t);
	}

}
