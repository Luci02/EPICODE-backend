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
		
		if ( prenotazioneRepository.findPrenotazioneByDataAndPostazione(prenotazione.getGiornoPrenotazione(), prenotazione.getPostazione()) == null ) {
			
			if ( prenotazioneRepository.findPrenotazioneByUtenteAndData(prenotazione.getUtente(), prenotazione.getGiornoPrenotazione()) == null ) {
				
				prenotazioneRepository.save(prenotazione);
				log.info("Prenotazione aggiunta correttamente nel DB!");
				
			}else {
				log.info("L'utente {} ha già una prenotazione attiva per quella data", prenotazione.getUtente().getNomeCompleto());
			}
			
		}else {
			log.info("La postazione selezionata non è disponibile per quella data!");
		}
	}

}
