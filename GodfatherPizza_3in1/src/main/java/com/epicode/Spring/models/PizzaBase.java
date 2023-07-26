package com.epicode.Spring.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public abstract class PizzaBase extends Consumabile {
	
	private List<String> ingredienti = new ArrayList<String>();

	public PizzaBase(Double prezzo, Integer informazioniNutrizionali) {
		super(prezzo, informazioniNutrizionali);
		this.ingredienti.add("pomodoro");
		this.ingredienti.add("mozzarella");
	}

}
