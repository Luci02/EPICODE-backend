package com.epicode.Spring.runners;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Edificio;
import com.epicode.Spring.models.Postazione;
import com.epicode.Spring.models.Prenotazione;
import com.epicode.Spring.models.Utente;
import com.epicode.Spring.services.EdificioService;
import com.epicode.Spring.services.PrenotazioneService;
import com.epicode.Spring.services.UtenteService;
import com.github.javafaker.Faker;

@Component
@Order(4)
public class PrenotazioneRunner implements CommandLineRunner {
	
	@Autowired PrenotazioneService prenotazioneService;
	@Autowired EdificioService edificioService;
	@Autowired UtenteService utenteService;

	@Override
	public void run(String... args) throws Exception {
		
		Random r = new Random();
		Faker f = new Faker(Locale.ITALY);
		List<Postazione> listaPostazioni = edificioService.findAllPostazione();
		List<Utente> listaUtenti = utenteService.findAllUtenti();
		
		for (int i = 0; i < 100; i++) {
			
			Prenotazione p = prenotazioneService.creaPrenotazione(
					LocalDate.of(2023, r.nextInt(1, 13), r.nextInt(1, 30)), 
					listaPostazioni.get(r.nextInt(listaPostazioni.size())), 
					listaUtenti.get(r.nextInt(listaUtenti.size()))
			);
			
			prenotazioneService.salvaPrenotazione(p);
			
		}
		
	}

}
