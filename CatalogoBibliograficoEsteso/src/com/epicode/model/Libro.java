package com.epicode.model;

import javax.persistence.Entity;

@Entity
public class Libro extends ElementoLetterario {

	private String autore;
	private String genere;
	
	public Libro() {
		super();
	}
	
	public Libro(String iSBN, String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore,
			String genere) {
		super(iSBN, titolo, annoPubblicazione, numeroPagine);
		this.setAutore(autore);
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", " + super.toString() + "]";
	}

}
