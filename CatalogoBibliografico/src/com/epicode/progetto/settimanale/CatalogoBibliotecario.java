package com.epicode.progetto.settimanale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatalogoBibliotecario {
	
	private static final Logger log = LoggerFactory.getLogger(CatalogoBibliotecario.class);
	
	private static Map<String, ElementoPubblicazione> archivio = new HashMap<String, ElementoPubblicazione>();

	public static void main(String[] args) {
		Libro l1 = new Libro("9788804766087", "Dieci cose che ho imparato", 2022, 156, "Piero Angela", "Politica e Società");
		Rivista r1 = new Rivista("1111111", "DIPIU’", 2023, 50, Periodicita.SETTIMANALE);
		
		aggiungiElemento(l1);
		aggiungiElemento(r1);
		
		ricercaPerISBN("9788804766087");
		List<ElementoPubblicazione> es3 = ricercaPerAnnoPubblicazione(2022);
		for (ElementoPubblicazione e : es3) {
			log.info("{}", e);
		}
	}
	
	public static void aggiungiElemento(ElementoPubblicazione e) {
		archivio.put(e.getISBN(), e);
		log.info("Elemento aggiunto in archivio correttamente. - " + e);
	}
	
	public static void rimuoviElemento(ElementoPubblicazione e) {
		archivio.remove(e.getISBN());
		log.info("Elemento rimosso dall'archivio. - " + e);
	}
	
	public static void ricercaPerISBN(String ISBN) {
		log.info( "Elemento trovato secondo il codice ISBN[{}]: {}", ISBN, archivio.get(ISBN) );
	}
	
	public static List<ElementoPubblicazione> ricercaPerAnnoPubblicazione(Integer anno) {
		return archivio.values().stream().filter( e -> e.getAnnoPubblicazione().equals(anno) ).collect(Collectors.toList());
	}

}
