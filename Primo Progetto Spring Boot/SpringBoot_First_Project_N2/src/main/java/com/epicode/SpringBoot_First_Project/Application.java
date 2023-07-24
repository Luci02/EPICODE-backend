package com.epicode.SpringBoot_First_Project;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.SpringBoot_First_Project.classes.Prodotto;
import com.epicode.SpringBoot_First_Project.configurationClasses.MenuConfiguration;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		List<Prodotto> menu = (List<Prodotto>) appContext.getBean("menu");
		
		System.out.println("***** GodFather's Pizza Menù *****");
		menu.forEach(p -> {
			System.out.println(p);
		});
	}

}
