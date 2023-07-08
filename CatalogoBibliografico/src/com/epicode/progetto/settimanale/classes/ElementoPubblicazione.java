package com.epicode.progetto.settimanale.classes;

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

	public Integer getnPagine() {
		return nPagine;
	}

	public void setnPagine(Integer nPagine) {
		this.nPagine = nPagine;
	}

	@Override
	public String toString() {
		return "ElementoPubblicazione [ISBN=" + ISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", nPagine=" + nPagine + "]";
	}

}
