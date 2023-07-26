package com.epicode.Spring.configuration;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.models.Ordine;
import com.epicode.Spring.models.Stato;
import com.epicode.Spring.models.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class OrdineConfiguration {
	
	@Value("${pizzeria.costoCoperto}") private Double costoCoperto;

	@Bean("ordineBean")
	@Scope("prototype")
	public Ordine nuovoOrdine() {
		Ordine o = new Ordine();
		o.setOraAquisizione(LocalTime.now());
		o.setStato(Stato.IN_CORSO);
		o.setCostoCoperto(costoCoperto);
		return o;
	}
	
	@Bean("tavoloBean")
	@Scope("prototype")
	public Tavolo nuovoTavolo() {
		return new Tavolo();
	}
	
}
