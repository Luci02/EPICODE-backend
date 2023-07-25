package com.epicode.classes;

import java.util.ArrayList;
import java.util.List;

public class HawaiianPizza extends Pizza {

	public HawaiianPizza() {
		super(6.49, 1024);
		
		List<String> addIngredients = new ArrayList<String>();
		addIngredients.add("prosciutto");
		addIngredients.add("ananas");
		
		super.setIngredients(addIngredients);
	}

}
