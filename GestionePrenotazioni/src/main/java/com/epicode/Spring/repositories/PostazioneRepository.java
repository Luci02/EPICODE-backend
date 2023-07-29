package com.epicode.Spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epicode.Spring.models.Postazione;
import com.epicode.Spring.models.enumerated.Tipo;

public interface PostazioneRepository extends CrudRepository<Postazione, Long> {

	@Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
	public List<Postazione> findPostazioneByTipoAndCitta(Tipo tipo, String citta);
	
}
