package com.epicode.Spring.models;

public class Hawaiian extends PizzaBase {

	public Hawaiian() {
		super(6.49, 1024);
		super.getIngredienti().add("prosciutto");
		super.getIngredienti().add("ananas");
	}
	
	@Override
	public String toString() {
		return "Hawaiian Pizza " + super.getIngredienti() 
			+ " calorie: " + super.getInformazioniNutrizionali()
			+ " prezzo: " + super.getPrezzo() + "€";
	}

}
