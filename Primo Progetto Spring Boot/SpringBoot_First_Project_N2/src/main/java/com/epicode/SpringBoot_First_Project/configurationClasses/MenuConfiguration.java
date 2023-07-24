package com.epicode.SpringBoot_First_Project.configurationClasses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.SpringBoot_First_Project.classes.PizzaHawaiian;
import com.epicode.SpringBoot_First_Project.classes.PizzaMargherita;
import com.epicode.SpringBoot_First_Project.classes.PizzaSalame;
import com.epicode.SpringBoot_First_Project.classes.Prodotto;

@Configuration
public class MenuConfiguration {
	
	@Bean
	@Scope("singleton")
	public List<Prodotto> menu() {
		List<Prodotto> Menu = new ArrayList<Prodotto>();
		
		Menu.add(pizzaMargherita());
		Menu.add(pizzaHawaiian());
		Menu.add(pizzaSalame());
		
		return Menu;
	}

	@Bean
	@Scope("singleton")
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}
	
	@Bean
	@Scope("singleton")
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}
	
	@Bean
	@Scope("singleton")
	public PizzaSalame pizzaSalame() {
		return new PizzaSalame();
	}

}
