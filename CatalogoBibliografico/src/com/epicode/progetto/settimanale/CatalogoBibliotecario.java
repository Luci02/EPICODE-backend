package com.epicode.progetto.settimanale;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.progetto.settimanale.classes.ElementoPubblicazione;
import com.epicode.progetto.settimanale.classes.Libro;
import com.epicode.progetto.settimanale.classes.Rivista;
import com.epicode.progetto.settimanale.enums.Periodicita;

public class CatalogoBibliotecario {
	
	private static final Logger log = LoggerFactory.getLogger(CatalogoBibliotecario.class);
	private static final File file = new File("documenti/archivio.txt");
	private static Map<String, ElementoPubblicazione> archivio = new HashMap<String, ElementoPubblicazione>();

	public static void main(String[] args) {
		Libro l1 = new Libro("9788804766087", "Dieci cose che ho imparato", 2022, 156, "Piero Angela", "Politica e Società");
		Rivista r1 = new Rivista("1111111", "DIPIU’", 2023, 50, Periodicita.SETTIMANALE);
		
		aggiungiElemento(l1);
		aggiungiElemento(r1);
		
		ElementoPubblicazione elementoTrovatoPerIsbn = ricercaPerISBN("1111111");
		log.info( "Elemento trovato secondo il codice ISBN[{}]: {}", elementoTrovatoPerIsbn.getISBN(), elementoTrovatoPerIsbn );
		
		List<ElementoPubblicazione> es3 = ricercaPerAnnoPubblicazione(2023);
		es3.forEach( e -> log.info("{}", e) );
		
		List<Libro> es5 = ricercaPerAutore("Piero Angela");
		es5.forEach( e -> log.info("{}", e) );
		
		try {
			salvataggioSuDisco();
			caricaDaDisco();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		rimuoviElementoDaISBN("9788804766087");
	}
	
	public static void aggiungiElemento(ElementoPubblicazione e) {
		archivio.put(e.getISBN(), e);
		log.info("Elemento aggiunto in archivio correttamente. - " + e);
	}
	
	public static void rimuoviElementoDaISBN(String ISBN) {
		ElementoPubblicazione e = archivio.remove(ISBN);
		log.info("Elemento rimosso dall'archivio correttamente. - " + e);
	}
	
	public static ElementoPubblicazione ricercaPerISBN(String ISBN) {
		return archivio.get(ISBN);
	}
	
	public static List<ElementoPubblicazione> ricercaPerAnnoPubblicazione(Integer anno) {
		return archivio.values().stream().filter( e -> anno.equals(e.getAnnoPubblicazione()) ).collect(Collectors.toList());
	}
	
	public static List<Libro> ricercaPerAutore(String autore) {
		return archivio.values()
				.stream()
				.filter( e -> e instanceof Libro )
				.map( e -> (Libro) e  )
				.filter( libro -> autore.equals( libro.getAutore() ) )
				.collect(Collectors.toList());
	}
	
	public static void salvataggioSuDisco() throws IOException {
		String txt = "";
		
		for (ElementoPubblicazione e : archivio.values()) {
			if (txt.length() != 0) {
				txt += "#";
			}
			if (e instanceof Libro) {
				txt += Libro.toStringFile((Libro) e);
			} else if (e instanceof Rivista) {
				txt += Rivista.toStringFile((Rivista) e);
			} 
		}
		FileUtils.writeStringToFile(file, txt, "UTF-8");
		log.info("Salvataggio su disco effettuato correttamente al path: {}", file.getPath());
	}
	
	public static void caricaDaDisco() throws IOException {
		archivio.clear();
		
		String txt = FileUtils.readFileToString(file, "UTF-8");
		
		List<String> lista = Arrays.asList(txt.split("#"));

		for (String e : lista) {
			ElementoPubblicazione elemento = null;
			if ( e.startsWith(Libro.class.getSimpleName()) ) {
				elemento = Libro.fromStringFile(e);
			} else if ( e.startsWith(Rivista.class.getSimpleName()) ) {
				elemento= Rivista.fromStringFile(e);
			}
			archivio.put(elemento.getISBN(), elemento);
		}
		log.info("Dati caricati correttamente dal file " + file.getPath());
	}
}