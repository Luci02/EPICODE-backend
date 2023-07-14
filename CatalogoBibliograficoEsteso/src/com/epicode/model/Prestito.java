package com.epicode.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito implements Serializable{
	
	// Ho creato l'attributo id perchè ho ritenuto più opportuno che lo stesso utente possa
	// prendere in prestito più libri ed anche uno stesso libro possa essere preso in prestito
	// da più persone, lasciando in memoria sul DB la storia dei possessori del libro

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name = "elemento_prestato_isbn")
	private ElementoLetterario elementoPrestato;
	
	@Column(name = "data_inizio_prestito", nullable = false)
	private LocalDate dataInizioPrestito;
	
	@Column(name = "data_restituzione_prevista", nullable = false)
	private LocalDate dataRestituzionePrevista;
	
	@Column(name = "data_restituzione_effettiva")
	private LocalDate dataRestituzioneEffettiva;
	
	public Prestito() {
		super();
	}
	
	public Prestito(Utente utente, ElementoLetterario elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzioneEffettiva) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public ElementoLetterario getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(ElementoLetterario elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}

	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}

	public LocalDate getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}

	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elementoPrestato=" + elementoPrestato + ", dataInizioPrestito="
				+ dataInizioPrestito + ", dataRestituzionePrevista=" + dataRestituzionePrevista
				+ ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
	}

}
