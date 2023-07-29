package com.epicode.Spring.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epicode.Spring.models.Postazione;
import com.epicode.Spring.models.Prenotazione;
import com.epicode.Spring.models.Utente;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {
	
	@Query("SELECT p FROM Prenotazione p WHERE p.giornoPrenotazione = :giornoPrenotazione AND p.postazione = :postazione")
    public Prenotazione findPrenotazioneByDataAndPostazione(LocalDate giornoPrenotazione, Postazione postazione);

    @Query("SELECT p FROM Prenotazione p WHERE p.utente = :utente AND p.giornoPrenotazione = :giornoPrenotazione")
    public Prenotazione findPrenotazioneByUtenteAndData(Utente utente, LocalDate giornoPrenotazione);

}