package com.epicode.Spring.main.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epicode.Spring.main.models.Utente;

public interface UtenteRepository extends CrudRepository<Utente, String> {

}
