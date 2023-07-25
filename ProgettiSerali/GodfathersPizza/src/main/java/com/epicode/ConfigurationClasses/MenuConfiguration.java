package com.epicode.ConfigurationClasses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.classes.HawaiianPizza;
import com.epicode.classes.Pizza;
import com.epicode.classes.PizzaMargherita;
import com.epicode.classes.SalamiPizza;

@Configuration
public class MenuConfiguration {
	
	private List<Pizza> menuPizze = new ArrayList<Pizza>();

	@Bean
	@Scope("singleton")
	public void menuPizze() {
		
	}
	
	@Bean
	@Scope("singleton")
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}
	
	@Bean
	@Scope("singleton")
	public HawaiianPizza hawaiianPizza() {
		return new HawaiianPizza();
	}
	
	public SalamiPizza salamiPizza() {
		return new SalamiPizza();
	}

}
