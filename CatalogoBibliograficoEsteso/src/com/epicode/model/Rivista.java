package com.epicode.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.epicode.enumerated.Periodicita;

@Entity
public class Rivista extends ElementoLetterario {

	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Rivista() {
		super();
	}
	
	public Rivista(String iSBN, String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
		super(iSBN, titolo, annoPubblicazione, numeroPagine);
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
		return "Rivista [periodicità=" + periodicita + ", " + super.toString() + "]";
	}
	
}