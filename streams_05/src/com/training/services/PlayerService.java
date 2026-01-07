package com.training.services;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.training.model.Player;
import com.training.model.Team;

public class PlayerService {

	private Set<Player> players ;
	
	public PlayerService() {
		super();
		this.players = init();
	}

	
	public Set<Player> init(){
		
		Player tendulkar = new Player(101,"Tendulkar",10);

		Player sundar = new Player(102,"Sundar",210);

		Player dravid = new Player(103,"Dravid",320);

		Player dhoni = new Player(204,"Abijit",610);

		Player kambli = new Player(402,"Kambli",120);
		
		Set<Player> playerList = new HashSet<>();
		
		playerList.add(tendulkar);
		playerList.add(sundar);
		playerList.add(dravid);
		playerList.add(dhoni);
		playerList.add(kambli);

		return playerList;
		
	}
	
	public Map<Team, Set<Player>> getTeams(){
		
		
		Team csk = new Team(2020, "CSK", "Whistle Podu");
		
		
		HashMap<Team, Set<Player>> teams = new HashMap<>();
		
		teams.put(csk, this.players);
		

		return teams;
		
	}
}
