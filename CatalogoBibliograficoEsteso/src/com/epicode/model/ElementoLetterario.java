package com.epicode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "elementi_letterari")
public abstract class ElementoLetterario {
	
	@Id	
	@Column(name = "isbn", nullable = false, unique = true)
	private String ISBN;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(name = "anno_pubblicazione")
	private Integer annoPubblicazione;
	
	@Column(name = "numero_pagine", nullable = false)
	private Integer numeroPagine;
	
	public ElementoLetterario() {
		super();
	}

	public ElementoLetterario(String iSBN, String titolo, Integer annoPubblicazione, Integer numeroPagine) {
		super();
		ISBN = iSBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Integer getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "ISBN=" + ISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + ", ";
	}

}
