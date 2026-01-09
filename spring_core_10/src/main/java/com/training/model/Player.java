package com.training.model;

import java.util.List;

public class Player  {

	
	private int playerId;
	private String playerName;
	private int jerseryNumber;
	
	private Address address;
	
	private List<String> awards;
	
	
	
	public List<String> getAwards() {
		return awards;
	}
	public void setAwards(List<String> awards) {
		this.awards = awards;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Player() {
		super();
		
		System.out.println("==== Constructor Called========");
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
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", jerseryNumber=" + jerseryNumber
				+ ", address=" + address + "]";
	}
	
	
	
	
}
