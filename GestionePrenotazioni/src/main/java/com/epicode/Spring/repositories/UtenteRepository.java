package com.epicode.Spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epicode.Spring.models.Utente;

public interface UtenteRepository extends CrudRepository<Utente, String> {

}
