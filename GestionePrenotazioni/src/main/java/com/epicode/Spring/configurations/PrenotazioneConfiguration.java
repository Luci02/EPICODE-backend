package com.epicode.Spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Prenotazione;

@Component
public class PrenotazioneConfiguration {
	
	@Bean("newPrenotazione")
	@Scope("prototype")
	public Prenotazione creaPrenotazione() {
		return new Prenotazione();
	}

}
