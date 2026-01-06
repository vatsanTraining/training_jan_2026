package com.training;

import com.training.ifaces.CrudOperation;
import com.training.impls.CrudOperationImpl;
import com.training.model.Player;
import com.training.services.PlayerService;

public class Application {

	public static void main(String[] args) {

		
		CrudOperation crud = new CrudOperationImpl(); // possible here because  there "is a" relationship  
		
		
		//CrudOperation crud2 = new PlayerService();  cannot do this since they are not related
		

		PlayerService service = new PlayerService(crud);
		
		
		Player tendulkar = new Player(101,"Tendulkar",10);
		
		System.out.println("is Added :="+service.add(tendulkar));
		
       Player sundar = new Player(102,"Sundar",210);
		
		System.out.println("is Added :="+service.add(sundar));
		
		
		Player[] players =service.findAll();
		
		
		for(Player eachPlayer :players) {
			
			if(eachPlayer !=null) {
				
			   System.out.println(eachPlayer);
			}
		}
		
		
	}

}
