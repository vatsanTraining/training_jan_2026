package com.training.impls;

import com.training.ifaces.CrudOperation;
import com.training.model.Player;

public class CrudOperationImpl implements CrudOperation {

	
	private Player[] players;
	
	private static int idxPos=0;   // variables have default value  its 0 for int
	
	public CrudOperationImpl() {
		super();
		
		this.players = new Player[3];
	}

	
	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}


	@Override
	public boolean add(Player player) {
		
		players[idxPos] = player;
		
		idxPos++;
		
		return idxPos<3?true:false;
	}


	@Override
	public Player[] findAll() {
		
		return this.players;
	}

	
}
