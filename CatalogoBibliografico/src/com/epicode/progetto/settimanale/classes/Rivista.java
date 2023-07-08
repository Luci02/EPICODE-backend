package com.epicode.progetto.settimanale.classes;

import com.epicode.progetto.settimanale.enums.Periodicita;

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
	
	public static String toStringFile(Rivista rivista) {
		return Rivista.class.getSimpleName()
				+ "@" + rivista.ISBN
				+ "@" + rivista.titolo
				+ "@" + rivista.annoPubblicazione
				+ "@" + rivista.nPagine
				+ "@" + rivista.periodicita;
	}
	
	public static Rivista fromStringFile(String stringFile) {
		String[] strMod = stringFile.split("@");
		Periodicita periodicita = Periodicita.valueOf(strMod[5]);
		
		return new Rivista(strMod[1], strMod[2], Integer.valueOf(strMod[3]), Integer.valueOf(strMod[4]), periodicita);
	}

}
