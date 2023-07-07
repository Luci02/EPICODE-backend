package com.epicode.progetto.settimanale;

public class Libro extends ElementoPubblicazione {
	
	String autore;
	String genere;
	
	public Libro(String iSBN, String titolo, Integer annoPubblicazione, Integer nPagine, String autore, String genere) {
		super(iSBN, titolo, annoPubblicazione, nPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", ISBN=" + ISBN + ", titolo=" + titolo
				+ ", annoPubblicazione=" + annoPubblicazione + ", nPagine=" + nPagine + "]";
	}
	
	
}
