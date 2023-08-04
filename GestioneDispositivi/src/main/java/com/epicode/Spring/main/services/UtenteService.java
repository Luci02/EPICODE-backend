package com.epicode.Spring.main.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring.main.models.Utente;
import com.epicode.Spring.main.repositories.UtenteRepository;

import jakarta.persistence.EntityExistsException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteService {
	
	@Autowired UtenteRepository utenteRepository;
	
	@Autowired @Qualifier("getFakeUser") ObjectProvider<Utente> utenteProvider;
	
	public Utente createFakeUser() {
		return utenteProvider.getObject();
	}
	
	public void saveUser(Utente u) {
		
		if (utenteRepository.existsById(u.getUsername())) {
			String msg = "L'utente " + u.getNome() + " " + u.getCognome() + " è già esistente!";
			throw new EntityExistsException(msg);
		}
		
		utenteRepository.save(u);
		log.info("Utente salvato correttamente sul DB: {}", u);
	}

}
