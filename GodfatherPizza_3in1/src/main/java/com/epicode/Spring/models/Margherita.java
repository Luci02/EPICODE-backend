package com.epicode.Spring.models;

public class Margherita extends PizzaBase {

	public Margherita() {
		super(4.99, 1104);
	}

	@Override
	public String toString() {
		return "Pizza Margherita " + super.getIngredienti() 
			+ " calorie: " + super.getInformazioniNutrizionali()
			+ " prezzo: " + super.getPrezzo() + "€";
	}

}