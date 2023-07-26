package com.epicode.Spring.models;

public class Salami extends PizzaBase {

	public Salami() {
		super(5.99, 1160);
		super.getIngredienti().add("salami");
	}
	
	@Override
	public String toString() {
		return "Salami Pizza " + super.getIngredienti() 
			+ " calorie: " + super.getInformazioniNutrizionali()
			+ " prezzo: " + super.getPrezzo() + "€";
	}

}