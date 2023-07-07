package com.epicode.progetto.settimanale;

public abstract class ElementoPubblicazione {
	
	String ISBN;
	String titolo;
	Integer annoPubblicazione;
	Integer nPagine;
	
	public ElementoPubblicazione(String iSBN, String titolo, Integer annoPubblicazione, Integer nPagine) {
		super();
		ISBN = iSBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.nPagine = nPagine;
	}

}
