package com.epicode.SpringBoot_First_Project.classes;

public abstract class Prodotto {
	
	private Double price;

	public Prodotto(Double price) {
		super();
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Prodotto [prezzo=" + price + "]";
	}

}
