package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.example.model.*;
public class UnderStoodLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
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

		
//		Predicate<String> test = new Predicate<String>() {
//			
//			@Override
//			public boolean test(String name) {
//				return name.contains("i");
//			}
//		};
//		
		Predicate<String> testForChar = (name) -> name.contains("i");
		
		
		// Type -1
		playerList.forEach((e)->System.out.println(e));

		
		// Type -2
		
		Consumer<Player> lambda = (e) -> System.out.println(e);

		
		playerList.forEach(lambda);
		
		// Type -3
		
		playerList.forEach(System.out::println);

		
		System.out.println("========= Names With I ======");
		
		playerList.forEach(e -> {
			
			//System.out.println(testForChar.test(e.getPlayerName()));
			
			if(testForChar.test(e.getPlayerName())) {
				System.out.println(e);
			}
		});
		
		
		
System.out.println("***** Names WITHOUT I ****");
		
		playerList.forEach(e -> {
			
			//System.out.println(testForChar.test(e.getPlayerName()));
			
			if(testForChar.negate().test(e.getPlayerName())) {
				System.out.println(e);
			}
		});
		
		
		Predicate<String> testForI = (name) -> name.contains("i");
		
		
		Predicate<String> testForR = (name) -> name.contains("K");

	
		Predicate<String> combined = testForI.or(testForR);

		
		
System.out.println("***** Names WITH I or R ****");
		
		playerList.forEach(e -> {
			
			if(combined.test(e.getPlayerName())) {
				System.out.println(e);
			}
		});

		
	}

}
