package com.training;

import java.util.Collection;

import com.training.ifaces.CrudOperation;
import com.training.ifaces.DuplicateElementException;
import com.training.impl.PlayerImpl;
import com.training.model.Player;
import com.training.services.PlayerService;

public class Application {

	public static void main(String[] args) {

		
		
		CrudOperation<Player> crud = new PlayerImpl();
		
		
	PlayerService service = new PlayerService(crud);
		
		
	addElements(service);
		
		
		Collection<Player> players =service.findAll();
		
		
		displayPlayers(players);
	
		
		Collection<Player> sortedList = service.playerListSortedByName();
		
		System.out.println("=== Players Sorted By Name =====");
		
       displayPlayers(sortedList);
	
		
	}

	protected static void addElements(PlayerService service) {
		
		Player tendulkar = new Player(101,"Tendulkar",10);

		try {
			System.out.println("is Added :="+service.add(tendulkar));
			Player sundar = new Player(102,"Sundar",210);

			System.out.println("is Added :="+service.add(sundar));


				Player dravid = new Player(103,"Dravid",320);

				System.out.println("is Added :="+service.add(dravid));


				Player dhoni = new Player(204,"Abijit",610);

				System.out.println("is Added :="+service.add(dhoni));

				Player kambli = new Player(402,"Kambli",120);

				System.out.println("is Added :="+service.add(kambli));

		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

	protected static void displayPlayers(Collection<Player> players) {
		
		for(Player eachPlayer : players) {
			
			System.out.println(eachPlayer);
		}
	}

	
}
