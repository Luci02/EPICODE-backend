package com.epicode.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Consumabile extends Prodotto {
	
	private Integer calories;

	public Consumabile(Double prezzo, Integer calories) {
		super(prezzo);
		this.calories = calories;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

}
