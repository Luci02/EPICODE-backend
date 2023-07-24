package com.epicode.SpringBoot_First_Project.classes;

import java.util.ArrayList;
import java.util.List;

public class PizzaHawaiian extends Pizza {

	public PizzaHawaiian() {
		super(6.49, 1024.0);
		List<String> additionalToppings = new ArrayList<String>();
		additionalToppings.add("prosciutto");
		additionalToppings.add("ananas");
		super.setToppings(additionalToppings);
	}

	@Override
	public String toString() {
		String str = "Pizza Hawaiana (";
		str += getToppings() + ") - Calorie: ";
		str += super.getCalories() + " - Prezzo: ";
		str += super.getPrice() + "€";
		return str;
	}

}
