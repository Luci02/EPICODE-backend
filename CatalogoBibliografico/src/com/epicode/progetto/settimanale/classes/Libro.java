package com.epicode.progetto.settimanale.classes;

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
	
	public static String toStringFile(Libro libro) {
		return Libro.class.getSimpleName()
				+ "@" + libro.ISBN
				+ "@" + libro.titolo
				+ "@" + libro.annoPubblicazione
				+ "@" + libro.nPagine
				+ "@" + libro.autore
				+ "@" + libro.genere;
	}
	
	public static Libro fromStringFile(String stringFile) {
		String[] strMod = stringFile.split("@");
		return new Libro(strMod[1], strMod[2], Integer.valueOf(strMod[3]), Integer.valueOf(strMod[4]), strMod[5], strMod[6]);
	}
	
	
}
