package com.training;
import java.util.function.*;
import java.util.stream.*;

import com.training.model.Player;
import com.training.model.Team;
import com.training.services.PlayerService;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {

	
	// using filter
	
	 public static List<Player>  usingFilter(Predicate<Player> condition,Stream<Player> stream){
		 
		
//		 stream.forEach(System.out::println);
//		 
//		 
//		 stream.filter(condition).forEach(System.out::println);

		 stream.filter(condition.negate()).forEach(System.out::println);

		 
		 return null;
	 }
	
	// using map
	
	
	// collect to a set
	
	// collect to a map
	
	// using flatmap
	
	// using max 
	

	// using sorting
	
	
	public static void main(String[] args) {

		
		
		
		PlayerService service = new PlayerService();
		
		
		    Map<Team, Set<Player>>  data  = service.getTeams();
		    
		     
		              Set<Player> players =data.get(new Team(2020, "CSK", "Whistle Podu"));

		                 
		   		    Stream<Player> stream = players.stream();

			Predicate<Player> testForChar = (player) -> player.getPlayerName().contains("i");

			
		    usingFilter(testForChar, stream);
		    
	}

}
