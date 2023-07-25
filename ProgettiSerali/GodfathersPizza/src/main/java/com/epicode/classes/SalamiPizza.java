package com.epicode.classes;

import java.util.ArrayList;
import java.util.List;

public class SalamiPizza extends Pizza {

	public SalamiPizza() {
		super(5.99, 1160);
		
		List<String> addIngredients = new ArrayList<String>();
		addIngredients.add("salami");
		
		super.setIngredients(addIngredients);
	}

}
