package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.training.ifaces.DuplicateElementException;
import com.training.model.Player;
import com.training.services.PlayerService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.training","com.example.demo"})
public class SpringBootCoreExerciseSolutionApplication {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext 	ctx=SpringApplication.run(SpringBootCoreExerciseSolutionApplication.class, args);
	

	
	
	PlayerService service =ctx.getBean(PlayerService.class);
	
			try {
				service.add(ctx.getBean("dravid",Player.class));
				service.add(ctx.getBean("sachin",Player.class));
			} catch (BeansException e) {
				e.printStackTrace();
			} catch (DuplicateElementException e) {
				e.printStackTrace();
			}
			
			
	service.findAll().forEach(System.out::println);
	
	

	
	ctx.close();
	
	}

	
}
