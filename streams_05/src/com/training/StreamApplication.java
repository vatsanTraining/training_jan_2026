package com.training;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

	 
	 public static List<String> getPlayerNames(Set<Player> players){
		 
		 return players.stream().map(e -> e.getPlayerName()).collect(toList());
	 }

    public static List<String> getPlayerNames(Set<Player> players,Predicate<Player> condition){
		 
    	// source.stream.intermediate1.intermediate2.terminal
    	
		 return players.stream().filter(condition).map(e -> e.getPlayerName()).collect(toList());
	 }
 
    
    public static Map<String,Integer> getPlayerNamesAndJerseyNumber(Set<Player> players){
		 
		 return players.stream().collect(toMap(Player::getPlayerName, Player::getJerseryNumber));
	 }
    
    
    public static Player  findMaxJerseyNumber(Set<Player> players) {
    	

          Optional<Integer> min = players.stream().map(e -> e.getJerseryNumber()).min(Integer::compareTo);
          
          if(min.isPresent()) {
        	  System.out.println("Min Value:=>"+ min.get());
          }
           
    	
    	Comparator<Player> comparator= Comparator.comparing(Player::getJerseryNumber);
    	
		 return players.stream().max(comparator).get();
		 

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
          
          System.out.println("Player Names");
          getPlayerNames(playerList).forEach(System.out::println);;
          
          System.out.println("Player with Jersey Number >20");
          getPlayerNames(playerList,condition1).forEach(System.out::println);
          
          
         System.out.println(findMaxJerseyNumber(playerList).getJerseryNumber());
		
	}

}




	
	// using flatmap
	
	