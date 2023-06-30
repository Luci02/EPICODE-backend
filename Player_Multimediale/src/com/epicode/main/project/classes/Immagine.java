package com.epicode.main.project.classes;

public class Immagine extends ElementoMultimediale {
	
	private int luminosita = 3; // Luminosità da 0 a 5 | Valore di default a 3

	public Immagine(String titolo) {
		super(titolo);
	}
	
	public void aumentaLuminosita() {
		
		if(this.luminosita != 5) {
			this.luminosita++;
			System.out.println("Hai alzato la luminosità al livello " + this.luminosita);
		}else {
			System.out.println("La luminosità è già al massimo");
		}
		
	}
	
	public void diminuisciLuminosita() {
		
		if(this.luminosita != 0) {
			this.luminosita--;
			System.out.println("Hai diminuito la luminosità al livello " + this.luminosita);
		}else {
			System.out.println("La luminosità è già al minimo");
		}
		
	}
	
	public void show() {
		System.out.println(this.titolo + " " + "*".repeat(this.luminosita));
		System.out.println();
	}

}
