package com.training.services;

import com.training.ifaces.CrudOperation;
import com.training.model.Player;

public class PlayerService {

	
	private CrudOperation crud;

	public PlayerService(CrudOperation crud) {
		super();
		this.crud = crud;
	}
	
	
	public Player[] findAll() {
		
		return this.crud.findAll();
	}
	
	public boolean add(Player player) {
		
		return this.crud.add(player);
	}
}
