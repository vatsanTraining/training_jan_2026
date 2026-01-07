package com.training.model;

import java.util.Objects;

public class Team {

	private int id;
	private String teamName;
	private String slogan;
	
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(int id, String teamName, String slogan) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.slogan = slogan;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", slogan=" + slogan + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, slogan, teamName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return id == other.id && Objects.equals(slogan, other.slogan) && Objects.equals(teamName, other.teamName);
	}
	
	
}
