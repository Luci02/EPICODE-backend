package com.epicode.progetto.settimanale;

public class Riviste extends ElementoPubblicazione {
	
	Periodicita periodicita;

	public Riviste(String iSBN, String titolo, Integer annoPubblicazione, Integer nPagine, Periodicita periodicita) {
		super(iSBN, titolo, annoPubblicazione, nPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

}
