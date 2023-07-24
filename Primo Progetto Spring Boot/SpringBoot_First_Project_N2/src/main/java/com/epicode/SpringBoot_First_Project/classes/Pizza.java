package com.epicode.SpringBoot_First_Project.classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza extends Consumabile {
	
	private List<String> toppings = new ArrayList<String>();

	public Pizza(Double price, Double calories) {
		super(price, calories);
		this.toppings.add("pomodoro");
		this.toppings.add("mozzarella");
	}

	public StringBuilder getToppings() {
		StringBuilder sb = new StringBuilder();
		this.toppings.forEach(t -> sb.append(t + ", "));
		sb.replace(sb.length() - 2, sb.length(), "");
		return sb;
	}

	public void setToppings(List<String> toppings) {
		this.toppings.addAll(toppings);
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
