package com.epicode.Spring.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.epicode.Spring.models.Utente;
import com.epicode.Spring.repositories.UtenteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UtenteService {
	
	@Autowired UtenteRepository utenteRepository;
	
	@Autowired @Qualifier("newUtente") private ObjectProvider<Utente> utenteProvider;
	
	// Metodi che ritornano i @Bean popolati
	
	public Utente creaUtente(String username, String nomeCompleto, String email) {
		return utenteProvider.getObject().builder()
				.username(username).nomeCompleto(nomeCompleto).email(email)
				.build();
	}
	
	// Metodi JPA
	
	public void salvaUtente(Utente utente) {
		utenteRepository.save(utente);
		log.info("{} aggiunto correttamente nel DB!", utente.getNomeCompleto());
	}

}
