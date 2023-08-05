package com.epicode.Spring.main.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.Spring.main.models.Utente;
import com.epicode.Spring.main.repositories.UtentePageableRepository;
import com.epicode.Spring.main.repositories.UtenteRepository;

import jakarta.persistence.EntityExistsException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteService {
	
	@Autowired UtenteRepository utenteRepository;
	@Autowired UtentePageableRepository pageableUsersRepo;
	
	@Autowired @Qualifier("getFakeUser") ObjectProvider<Utente> fakeUtenteProvider;
	
	public Utente createFakeUser() {
		return fakeUtenteProvider.getObject();
	}
	
	public void saveUser(Utente u) {
		
		if (utenteRepository.existsById(u.getUsername())) {
			String msg = "L'utente " + u.getNome() + " " + u.getCognome() + " è già esistente!";
			throw new EntityExistsException(msg);
		}
		
		utenteRepository.save(u);
		log.info("Utente salvato correttamente sul DB: {}", u);
	}
	
	public void updateUser(Utente u) {
		
		utenteRepository.save(u);
		log.info("Dati aggiornati correttamente sul DB: {}", u);
		
	}
	
	public void deleteUser( String username ) {
		utenteRepository.deleteById(username);
		log.info("Utente eliminato correttamente dal DB: {}", username);
	}
	
	public Page<Utente> getAllUsers(Pageable pageable) {
		return pageableUsersRepo.findAll(pageable);
	}

	public Utente getSingleUser(String username) {
		return utenteRepository.findById(username).get();
	}
}
