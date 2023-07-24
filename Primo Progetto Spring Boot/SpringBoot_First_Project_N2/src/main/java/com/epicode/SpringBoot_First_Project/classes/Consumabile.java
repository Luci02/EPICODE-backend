package com.epicode.SpringBoot_First_Project.classes;

public abstract class Consumabile extends Prodotto {
	
	private Double calories;

	public Consumabile(Double price, Double calories) {
		super(price);
		this.setCalories(calories);
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Consumabile [calories=" + calories + "]";
	}
	
}
