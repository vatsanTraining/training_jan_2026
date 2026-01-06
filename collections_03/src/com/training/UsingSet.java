package com.training;

import java.util.Collection;

import com.training.ifaces.CrudOperation;
import com.training.impl.PlayerImpl;
import com.training.impl.PlayerImplWithSet;
import com.training.model.Player;
import com.training.services.PlayerService;

public class UsingSet {

	public static void main(String[] args) {

		
		CrudOperation<Player> crud = new PlayerImplWithSet();
		
		
		PlayerService service = new PlayerService(crud);
			
			
		Application.addElements(service);
		
		
		  Collection<Player> setView = service.findAll();
		  
		  System.out.println("Hash Set Not Sorted in anyWay");
		  
		  Application.displayPlayers(setView);
		  
		  
		  Collection<Player> treeView = service.playerListAsTreeSet();
		  
		  System.out.println("Tree Set Sorted by Name");
		  
		  Application.displayPlayers(treeView);
		 
		  
		  
		  
		  
	}

}
