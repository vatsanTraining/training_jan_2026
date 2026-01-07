package com.training;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.*;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.training.model.Player;

public class StreamApplication {

	// using filter
	
	 public static List<Player>  usingFilter(Set<Player> players){
		 
		
		// players.stream().filter(e -> e.getPlayerId()>200).forEach(System.out::println);
		 
		 return players.stream().filter(e -> e.getPlayerId()>200).collect(toList());

	 }

	 public static List<Player>  usingFilter(Set<Player> players,Predicate<Player> condition){
		 
			
			 
			 return players.stream().filter(condition).collect(toList());

		 }


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
		
		
		usingFilter(playerList).forEach(System.out::println);
		
		
          Predicate<Player> condition1  = e -> e.getPlayerId()>200;
          
          Predicate<Player> condition2  = e -> e.getJerseryNumber()>20;
          
          usingFilter(playerList, condition2);
		
	}

}


//using map


	// collect to a set
	
	// collect to a map
	
	// using flatmap
	
	// using max 
	