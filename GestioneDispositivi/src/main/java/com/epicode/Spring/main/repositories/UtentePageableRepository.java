package com.epicode.Spring.main.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.Spring.main.models.Utente;

public interface UtentePageableRepository extends PagingAndSortingRepository<Utente, String> { }
