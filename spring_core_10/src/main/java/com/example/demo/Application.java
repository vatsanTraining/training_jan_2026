package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.model.Player;

public class Application {

	public static void main(String[] args) {

		
		  BeanFactory ctx = new ClassPathXmlApplicationContext("bean.xml");
		  
		  
		  Player sachin = ctx.getBean(Player.class);
		  
		  System.out.println(sachin);
		  
		  System.out.println(sachin.getAwards());
		  ((ConfigurableApplicationContext)ctx).close();
		  
//		  Player sachin = new Player();
//		  sachin.setPlayerId(1020);
//		  sachin.setJerseryNumber(10);
//		  sachin.setPlayerName("Sachin");
		  
		  // List<String> awards = new ArrayList<>();
		  //awards.add("");
		  // saching.setAwards(awards)
	}

}


// collection
// autowire