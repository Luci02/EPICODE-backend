package com.epicode.Spring.models;

import lombok.Data;

@Data
public abstract class Consumabile extends Prodotto {

	private Integer informazioniNutrizionali;

	public Consumabile(Double prezzo, Integer informazioniNutrizionali) {
		super(prezzo);
		this.informazioniNutrizionali = informazioniNutrizionali;
	}

}