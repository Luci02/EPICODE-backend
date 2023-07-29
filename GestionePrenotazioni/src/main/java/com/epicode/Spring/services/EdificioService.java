package com.epicode.Spring.services;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.epicode.Spring.models.Edificio;
import com.epicode.Spring.models.Postazione;
import com.epicode.Spring.models.enumerated.Tipo;
import com.epicode.Spring.repositories.EdificioRepository;
import com.epicode.Spring.repositories.PostazioneRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EdificioService {
	
	@Autowired EdificioRepository edificioRepository;
	@Autowired PostazioneRepository postazioneRepository;
	
	@Autowired @Qualifier("newEdificio") private ObjectProvider<Edificio> edificioProvider;
	@Autowired @Qualifier("newPostazione") private ObjectProvider<Postazione> postazioneProvider;
	
	// Metodi che ritornano i @Bean popolati

	public Edificio creaEdificio(String nome, String indirizzo, String citta) {
		return edificioProvider.getObject().builder()
				.nome(nome).indirizzo(indirizzo).citta(citta)
				.build();
	}
	
	public Postazione creaPostazione(String descrizione, Tipo tipo, int maxNumOccupanti, Edificio edificio) {
		return postazioneProvider.getObject().builder()
				.descrizione(descrizione).tipo(tipo).maxNumOccupanti(maxNumOccupanti).edificio(edificio)
				.build();
	}
	
	// Metodi JPA
	
	public void salvaEdificio(Edificio edificio) {
		edificioRepository.save(edificio);
		log.info( "{} aggiunto correttamente nel DB!", edificio.getNome() );
	}
	
	public List<Edificio> trovaListaEdifici() {
		return (List<Edificio>) edificioRepository.findAll();
	}
	
	public void salvaPostazione(Postazione postazione) {
		postazioneRepository.save(postazione);
		log.info( "{} in {} aggiunta correttamente nel DB!", postazione.getDescrizione(), postazione.getEdificio() );
	}
}
