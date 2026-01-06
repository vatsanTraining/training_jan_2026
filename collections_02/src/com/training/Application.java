package com.training;

import java.util.List;

import com.training.ifaces.CrudOperation;
import com.training.impls.CrudWithListImpl;
import com.training.model.Player;
import com.training.services.PlayerService;

public class Application {

	public static void main(String[] args) {

		
		
		CrudOperation crud = new CrudWithListImpl();
		
		
	PlayerService service = new PlayerService(crud);
		
		
		Player tendulkar = new Player(101,"Tendulkar",10);
		
		System.out.println("is Added :="+service.add(tendulkar));
		
       Player sundar = new Player(102,"Sundar",210);
		
		System.out.println("is Added :="+service.add(sundar));
		
		
		Player[] players =service.findAll();
		
		
		
		
		
		for(Player eachPlayer : players) {
			
			System.out.println(eachPlayer);
		}
	
	}

}
