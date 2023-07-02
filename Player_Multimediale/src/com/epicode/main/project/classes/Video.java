package com.epicode.main.project.classes;

import com.epicode.main.project.interfaces.Luminosita;

public class Video extends ElementoRiproducibile implements Luminosita {
	
	private int luminosita = 3; // Luminosità da 0 a 5 | Valore di default a 3

	public Video(String titolo, int durata) {
		super(titolo, durata);
	}
	
	@Override
	public void aumentaLuminosita() {
		
		if(this.luminosita != 5) {
			this.luminosita++;
			System.out.println("Hai alzato la luminosità al livello " + this.luminosita);
		}else {
			System.out.println("La luminosità è già al massimo");
		}
		
	}
	
	@Override
	public void diminuisciLuminosita() {
		
		if(this.luminosita != 0) {
			this.luminosita--;
			System.out.println("Hai diminuito la luminosità al livello " + this.luminosita);
		}else {
			System.out.println("La luminosità è già al minimo");
		}
		
	}

	@Override
	public void play() {

		for (int i = 0; i < this.durata; i++) {
			System.out.println(this.titolo + " " + "!".repeat(this.volume) + " " + "*".repeat(this.luminosita));
		}
		
		System.out.println();
		
	}

}
