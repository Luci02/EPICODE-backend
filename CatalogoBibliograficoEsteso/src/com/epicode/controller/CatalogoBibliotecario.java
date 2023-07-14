package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.enumerated.Periodicita;
import com.epicode.model.ElementoLetterario;
import com.epicode.model.Libro;
import com.epicode.model.Prestito;
import com.epicode.model.Rivista;
import com.epicode.model.Utente;

public class CatalogoBibliotecario {
	
	static EntityManager em = Persistence.createEntityManagerFactory("CatalogoBibliograficoEsteso").createEntityManager();

	public static void main(String[] args) {
		
		try {
			
			// Elenco Utenti
			Utente u1 = new Utente("Robert", "De Niro", LocalDate.of(1943, 8, 17), "XP47093505");
			Utente u2 = new Utente("Ben", "Stiller", LocalDate.of(1965, 11, 30), "MY18217682");
			Utente u3 = new Utente("Angelina", "Jolie", LocalDate.of(1975, 06, 04), "TT71460357");
			Utente u4 = new Utente("Dwayne", "Johnson", LocalDate.of(1972, 05, 2), "RM31765137");
			// aggiungiUtente(u4);
			
			// Elenco Libri e Riviste		
			Libro l1 = new Libro("9788804746676", "Il Codice da Vinci", 2022, 516, "Dan Brown", "Romanzo thriller");
			Libro l2 = new Libro("9788831003384", "Harry Potter e la pietra filosofale", 2020, 304, "J. K. Rowling", "Romanzo");
			Libro l3 = new Libro("9788845927553", "Lo Hobbit", 1937, 342, "J. R. R. Tolkien", "Romanzo");
			
			Rivista r1 = new Rivista("9789750261039", "Focus", 2023, 100, Periodicita.MENSILE);
			Rivista r2 = new Rivista("9783534492718", "ATHLETA", 2023, 50, Periodicita.SEMESTRALE);
			Rivista r3 = new Rivista("9784489111204", "La Settimana Enigmistica", 2023, 35, Periodicita.SETTIMANALE);
			// aggiungiElemento(r3);
			
			// Elenco Prestiti
			Prestito p1 = new Prestito(u1, r3, LocalDate.of(2023, 06, 8), null);
			Prestito p2 = new Prestito(u2, l2, LocalDate.of(2023, 07, 14), LocalDate.of(2023, 07, 31));
			Prestito p3 = new Prestito(u3, r2, LocalDate.of(2021, 03, 2), LocalDate.of(2021, 04, 2));
			Prestito p4 = new Prestito(u4, l1, LocalDate.of(2020, 12, 25), null);
			Prestito p5 = new Prestito(u1, l3, LocalDate.of(2023, 07, 14), null);
			// aggiungiPrestito(p5);
			
			// Utilizzo dei Metodi			
			   ricercaPerIsbn("9788845927553");
			// ricercaPerAnnoPubblicazione(1937);
			// ricercaPerAutore("J. K. Rowling");
			// ricercaPerTitolo("o");
			// ricercaPrestitoDaTessera("XP47093505");
			// ricercaPrestitiScadutiNonRestituiti(LocalDate.of(2024, 07, 14));
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		
	}
	
	static void aggiungiElemento(ElementoLetterario e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Elemento aggiunto al DB: " + e);
	}
	
	static void aggiungiUtente(Utente u) throws SQLException {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente aggiunto al DB: " + u);
	}
	
	static void aggiungiPrestito(Prestito p) throws SQLException {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Prestito aggiunto al DB: " + p);
	}
	
	static void rimuovi(String ISBN) throws SQLException {
		em.getTransaction().begin();
		ElementoLetterario e = em.find(ElementoLetterario.class, ISBN);
		em.remove(e);
		em.getTransaction().commit();
	}
	
	static void ricercaPerIsbn(String ISBN) throws SQLException {
		em.getTransaction().begin();
		ElementoLetterario e = em.find(ElementoLetterario.class, ISBN);
		em.getTransaction().commit();
		
		System.out.println("Elemento trovato: " + e);
	}
	
	static void ricercaPerAnnoPubblicazione(int anno) throws SQLException {
		
		Query query = em.createQuery("SELECT e FROM ElementoLetterario e WHERE e.annoPubblicazione = :anno ORDER BY e.titolo");
		query.setParameter("anno", anno);
		List<ElementoLetterario> resultList = query.getResultList();

		if( resultList.size() == 0 ) {
			System.out.println("Non sono stati trovati risultati.");
		}else {			
			resultList.forEach( el -> System.out.println(el) );
		}

	}
	
	static void ricercaPerAutore(String autore) throws SQLException {
		
		Query query = em.createQuery("SELECT e FROM ElementoLetterario e WHERE e.autore = :autore ORDER BY e.titolo");
		query.setParameter("autore", autore);
		List<ElementoLetterario> resultList = query.getResultList();

		if( resultList.size() == 0 ) {
			System.out.println("Non sono stati trovati risultati.");
		}else {			
			resultList.forEach( el -> System.out.println(el) );
		}

	}
	
	static void ricercaPerTitolo(String titolo) throws SQLException {
		
		Query query = em.createQuery("SELECT e FROM ElementoLetterario e WHERE e.titolo LIKE :titolo ORDER BY e.titolo");
		query.setParameter("titolo", "%"+titolo+"%");
		List<ElementoLetterario> resultList = query.getResultList();

		if( resultList.size() == 0 ) {
			System.out.println("Non sono stati trovati risultati.");
		}else {			
			resultList.forEach( el -> System.out.println(el) );
		}

	}
	
	static void ricercaPrestitoDaTessera(String nTessera) throws SQLException {
		Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :nTessera");
		query.setParameter("nTessera", nTessera);
		List<Prestito> resultList = query.getResultList();

		if( resultList.size() == 0 ) {
			System.out.println("Non sono stati trovati risultati.");
		}else {			
			resultList.forEach( p -> System.out.println(p) );
		}
	}
	
	static void ricercaPrestitiScadutiNonRestituiti(LocalDate data) throws SQLException {
		Query query = em.createQuery("SELECT p FROM Prestito p WHERE :data > p.dataRestituzionePrevista AND p.dataRestituzioneEffettiva IS NULL");
		query.setParameter("data", data);
		List<Prestito> resultList = query.getResultList();

		if( resultList.size() == 0 ) {
			System.out.println("Non sono stati trovati risultati.");
		}else {			
			resultList.forEach( p -> System.out.println(p) );
		}
	}

}
