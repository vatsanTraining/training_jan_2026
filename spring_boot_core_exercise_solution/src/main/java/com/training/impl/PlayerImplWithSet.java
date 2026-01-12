package com.training.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import com.training.ifaces.CrudOperation;
import com.training.model.Player;

public class PlayerImplWithSet implements CrudOperation<Player> {
	
	private HashSet<Player> hashSet;
	
	private TreeSet<Player> treeSet;
	
	public PlayerImplWithSet() {
		super();
		
		this.hashSet = new HashSet<>();
		this.treeSet = new TreeSet<>();
	}

	@Override
	public boolean add(Player t) {
		
		this.hashSet.add(t);
		this.treeSet.add(t);
		
		return true;
	}

	@Override
	public Collection<Player> findAll() {
		return this.hashSet;
	}

	@Override
	public boolean remove(Player t) {
		return this.hashSet.remove(t);
	}
	
	
	public TreeSet<Player> getTreeSet() {
		return treeSet;
	}


}
