package com.epicode.Spring.services;

import java.time.LocalDate;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring.models.Postazione;
import com.epicode.Spring.models.Prenotazione;
import com.epicode.Spring.models.Utente;
import com.epicode.Spring.repositories.PrenotazioneRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrenotazioneService {
	
	@Autowired PrenotazioneRepository prenotazioneRepository;
	
	@Autowired @Qualifier("newPrenotazione") private ObjectProvider<Prenotazione> prenotazioneProvider;
	
	// Metodi che ritornano i @Bean popolati
	public Prenotazione creaPrenotazione(LocalDate giornoPrenotazione, Postazione postazione, Utente utente) {
		return prenotazioneProvider.getObject().builder()
				.giornoPrenotazione(giornoPrenotazione).postazione(postazione).utente(utente)
				.build();
	}
	
	// Metodi JPA
	
	public void salvaPrenotazione(Prenotazione prenotazione) {
		prenotazioneRepository.save(prenotazione);
		log.info("Prenotazione aggiunta correttamente nel DB!");
	}

}
