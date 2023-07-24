package com.epicode.SpringBoot_First_Project.classes;

public class PizzaMargherita extends Pizza {

	public PizzaMargherita() {
		super(4.99, 1104.0);
	}
	
	@Override
	public String toString() {
		String str = "Pizza Margherita (";
		str += getToppings() + ") - Calorie: ";
		str += super.getCalories() + " - Prezzo: ";
		str += super.getPrice() + "€";
		return str;
	}
}
