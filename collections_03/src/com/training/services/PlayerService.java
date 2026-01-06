package com.training.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.training.ifaces.CrudOperation;
import com.training.impl.PlayerImplWithSet;
import com.training.model.Player;

public class PlayerService {

	
	private CrudOperation<Player> crud;

	public PlayerService(CrudOperation<Player> crud) {
		
		this.crud = crud;
	}
	
	
	public boolean add(Player player) {
		
		return this.crud.add(player);
	}
	
	public Collection<Player> findAll(){
		
		
		return this.crud.findAll();
	}
	
	
	public boolean remove(Player player) {
		
		return this.crud.remove(player);
	}
	
	
	public Collection<Player> playerListSortedByName(){
		
		
		List<Player> players = (List<Player>)findAll();
		
		Collections.sort(players);
		
		return players;
		
	}
	
	public Collection<Player> playerListAsTreeSet(){
		
		return ((PlayerImplWithSet)crud).getTreeSet();
	}
}
