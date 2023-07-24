package com.epicode.SpringBoot_First_Project.classes;

import java.util.ArrayList;
import java.util.List;

public class PizzaSalame extends Pizza {

	public PizzaSalame() {
		super(5.99, 1160.0);
		List<String> additionalToppings = new ArrayList<String>();
		additionalToppings.add("salame");
		super.setToppings(additionalToppings);
	}
	
	@Override
	public String toString() {
		String str = "Pizza con Salame (";
		str += getToppings() + ") - Calorie: ";
		str += super.getCalories() + " - Prezzo: ";
		str += super.getPrice() + "€";
		return str;
	}

	

}
