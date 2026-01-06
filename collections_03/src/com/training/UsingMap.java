package com.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.training.model.Player;
import com.training.model.Team;

public class UsingMap {

	public static void main(String[] args) {

		
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
		System.out.println(playerList.add(kambli));
		

		System.out.println(" Size :=>"+ playerList.size());
		
		
		Team kkr = new Team(1020, "KKR", "This year the cup is ours");
		
		
		Team csk = new Team(2020, "CSK", "Whistle Podu");
		
		
		HashMap<Team, Set<Player>> teams = new HashMap<>();
		
		teams.put(csk, playerList);
		
		teams.put(kkr, playerList);
		
		Set<Player> cskPlayers =teams.get(csk);
		
		for(Player eachPlayer:cskPlayers) {
			
			System.out.println(eachPlayer);
		}
		
		
		Set<Map.Entry<Team, Set<Player>>> teamList = teams.entrySet();
		
		
		for(Map.Entry<Team, Set<Player>> eachItem: teamList ) {
			
			System.out.println("======"+eachItem.getKey().getTeamName()+"=====");
			
			for(Player eachPlayer : eachItem.getValue()) {
				
				System.out.println(eachPlayer);
			}
		}
	}

}
