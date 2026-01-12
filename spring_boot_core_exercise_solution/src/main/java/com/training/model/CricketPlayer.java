package com.training.model;

public class CricketPlayer extends Player {

	
	private int runs;
	private int wickets;
	public CricketPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CricketPlayer(int playerId, String playerName, int jerseryNumber) {
		super(playerId, playerName, jerseryNumber);
		// TODO Auto-generated constructor stub
	}
	public CricketPlayer(int playerId, String playerName, int jerseryNumber, int runs, int wickets) {
		super(playerId, playerName, jerseryNumber);
		this.runs = runs;
		this.wickets = wickets;
	}
	
	
}
