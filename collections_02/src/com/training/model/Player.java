package com.training.model;

public class Player  {

	
	private int playerId;
	private String playerName;
	private int jerseryNumber;
	
	public Player() {
		super();
	}
	public Player(int playerId, String playerName, int jerseryNumber) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseryNumber = jerseryNumber;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getJerseryNumber() {
		return jerseryNumber;
	}
	public void setJerseryNumber(int jerseryNumber) {
		this.jerseryNumber = jerseryNumber;
	}
	@Override
	public String toString() {
		return this.playerName +"," +this.jerseryNumber;
	}
	
	
	
	
}
