package com.training;

import java.util.Map;
import java.util.Set;

import com.training.model.Player;
import com.training.model.Team;
import com.training.services.PlayerService;

import static java.util.stream.Collectors.*;

import java.sql.DriverManager;
import java.util.List;

public class UsingFlatMap {

	public static void main(String[] args) {

		
		DriverManager mgr = null;
		
		
		int var =10;
		
		System.out.println(var);
		
		var service = new PlayerService();
		
		
	    Map<Team, Set<Player>>  data  = service.getTeams();
	    

	   List<Player> players = data.values().stream().peek(e -> System.out.println("what is passed"+e)).flatMap(Set::stream).collect(toList());
	   
	       players.forEach(System.out::println);
	       
	       
	       var a = 5;
	       
	       
	}

}
