package com.training.model;

import java.util.Objects;

public class Player implements Comparable<Player>  {

	
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
	@Override
	public int hashCode() {
		return Objects.hash(jerseryNumber, playerId, playerName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Player other = (Player) obj;
		
		return jerseryNumber == other.jerseryNumber && playerId == other.playerId
				&& Objects.equals(playerName, other.playerName);
	}
	@Override
	public int compareTo(Player obj) {

		return this.playerName.compareTo(obj.playerName);
	}
	
	
}
