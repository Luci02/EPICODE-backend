package com.epicode.SpringBoot_First_Project.classes;

public abstract class Prodotto {
	
	private Double prezzo;

	public Prodotto(Double prezzo) {
		super();
		this.prezzo = prezzo;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Prodotto [prezzo=" + prezzo + "]";
	}

}
