package com.training.model;

public class Team {

	
	private Player player;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Team [player=" + player + "]";
	}
	
	
	
}
