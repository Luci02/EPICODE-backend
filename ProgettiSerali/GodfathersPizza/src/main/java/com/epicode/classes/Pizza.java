package com.epicode.classes;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class Pizza extends Consumabile {
	
	private List<String> ingredients = new ArrayList<String>();

	public Pizza(Double prezzo, Integer calories) {
		super(prezzo, calories);
		this.ingredients.add("pomodoro");
		this.ingredients.add("mozzarella");
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients.addAll(ingredients);
	}

}
