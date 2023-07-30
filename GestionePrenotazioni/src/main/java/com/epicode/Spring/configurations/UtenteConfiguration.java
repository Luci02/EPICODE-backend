package com.epicode.Spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Utente;

@Component
public class UtenteConfiguration {
	
	@Bean("newUtente")
	@Scope("prototype")
	public Utente creaUtente() {
		return new Utente();
	}

}
