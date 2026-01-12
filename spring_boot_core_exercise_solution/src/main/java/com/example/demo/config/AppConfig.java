package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.ifaces.CrudOperation;
import com.training.impl.*;
import com.training.model.Player;
import com.training.services.PlayerService;
@Configuration
public class AppConfig {

	@Bean
	CrudOperation<Player> listRepo() {
        return new PlayerImpl();
    }

    @Bean
     CrudOperation<Player> setRepo() {
        return new PlayerImplWithSet();
    }

    @Bean
     PlayerService playerService() {
        return new PlayerService(listRepo());
    }
    
    @Bean
    Player dravid() {
       return new Player(1010,"Dravid",50);
   }
    
    @Bean
    Player sachin() {
       return new Player(2020,"Sachin",10);
   }
    
}
