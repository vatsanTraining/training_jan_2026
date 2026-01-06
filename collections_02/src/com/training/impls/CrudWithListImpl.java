package com.training.impls;

import java.util.*;

import com.training.ifaces.CrudOperation;
import com.training.model.Player;

public class CrudWithListImpl implements CrudOperation {
	
	
	private List<Player> players ;
	
	

	public CrudWithListImpl() {
		super();
		
		this.players = new ArrayList<>();
		
		//this.players = new Player[3];

		
	}

	
	@Override
	public boolean add(Player player) {

		return this.players.add(player);
		
	}


	@Override
	public Player[] findAll() {

		return this.players.toArray(new Player[0]);
	}

	
	
}
