package com.epicode.Spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.models.Hawaiian;
import com.epicode.Spring.models.Margherita;
import com.epicode.Spring.models.Menu;
import com.epicode.Spring.models.Salami;

@Configuration
public class PizzaConfiguration {
	
	@Bean("menuBean")
	public Menu menu() {
		Menu m = new Menu();
		m.getMenuPizze().add( pizzaMargherita() );
		m.getMenuPizze().add( pizzaHawaiian() );
		m.getMenuPizze().add( pizzaSalami() );
		return m;
	}

	@Bean
	@Scope("singleton")
	public Margherita pizzaMargherita() {
		return new Margherita();
	}
	
	@Bean
	@Scope("singleton")
	public Hawaiian pizzaHawaiian() {
		return new Hawaiian();
	}
	
	@Bean
	@Scope("singleton")
	public Salami pizzaSalami() {
		return new Salami();
	}

}
