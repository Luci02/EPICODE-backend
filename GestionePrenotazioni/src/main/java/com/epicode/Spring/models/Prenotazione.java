package com.epicode.Spring.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "giorno_prenotazione")
	private LocalDate giornoPrenotazione;
	
	@ManyToOne
	private Postazione postazione;
	
	@ManyToOne
	private Utente utente;

	public Prenotazione(LocalDate giornoPrenotazione, Postazione postazione, Utente utente) {
		super();
		this.giornoPrenotazione = giornoPrenotazione;
		this.postazione = postazione;
		this.utente = utente;
	}
	
}
