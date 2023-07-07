package com.epicode.progetto.settimanale;

public class Rivista extends ElementoPubblicazione {
	
	Periodicita periodicita;

	public Rivista(String iSBN, String titolo, Integer annoPubblicazione, Integer nPagine, Periodicita periodicita) {
		super(iSBN, titolo, annoPubblicazione, nPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Riviste [periodicita=" + periodicita + ", ISBN=" + ISBN + ", titolo=" + titolo + ", annoPubblicazione="
				+ annoPubblicazione + ", nPagine=" + nPagine + "]";
	}

}
