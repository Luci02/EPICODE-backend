package com.epicode.Spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Edificio;
import com.epicode.Spring.models.Postazione;

@Component
public class EdificioConfiguration {
	
	@Bean("newEdificio")
	@Scope("prototype")
	public Edificio newEdificio() {
		return new Edificio();
	}
	
	@Bean("newPostazione")
	@Scope("prototype")
	public Postazione newPostazione() {
		return new Postazione();
	}

}
