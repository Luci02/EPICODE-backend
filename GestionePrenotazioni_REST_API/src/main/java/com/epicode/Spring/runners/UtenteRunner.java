package com.epicode.Spring.runners;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Utente;
import com.epicode.Spring.services.UtenteService;
import com.github.javafaker.Faker;

@Component
@Order(3)
public class UtenteRunner implements CommandLineRunner {
	
	@Autowired UtenteService utenteService;

	@Override
	public void run(String... args) throws Exception {
		
		Faker f = new Faker(Locale.ITALY);
		
		for (int i = 0; i < 5; i++) {
			Utente utente = utenteService.creaUtente(f.name().username(), f.name().fullName(), f.internet().emailAddress());
			utenteService.salvaUtente(utente);
		}
		
	}

}
