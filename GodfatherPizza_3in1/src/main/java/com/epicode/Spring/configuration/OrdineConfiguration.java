package com.epicode.Spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.models.Ordine;
import com.epicode.Spring.models.Tavolo;

@Configuration
public class OrdineConfiguration {

	@Bean
	@Scope("prototype")
	public Ordine nuovoOrdine() {
		return new Ordine();
	}
	
	@Bean
	@Scope("prototype")
	public Tavolo nuovoTavolo() {
		return new Tavolo();
	}
	
}
