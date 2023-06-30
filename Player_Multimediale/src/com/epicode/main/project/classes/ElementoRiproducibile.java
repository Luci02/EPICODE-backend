package com.epicode.main.project.classes;

import com.epicode.main.project.interfaces.Riproducibile;

public abstract class ElementoRiproducibile extends ElementoMultimediale implements Riproducibile {
	
	int durata;
	int volume = 3; // Volume da 0 a 5 | Valore di default a 3

	public ElementoRiproducibile(String titolo, int durata) {
		super(titolo);
		this.durata = durata;
	}
	
//	Astratto perchè Audio e Video hanno funzionamenti leggermente diversi
	public abstract void play();
	
	public void alzaVolume() {
		
		if(this.volume != 5) {
			this.volume++;
			System.out.println("Hai alzato il volume al livello " + this.volume);
		}else {
			System.out.println("Il volume è già al massimo");
		}
		
	}
	
	public void abbassaVolume() {
		
		if(this.volume != 0) {
			this.volume--;
			System.out.println("Hai abbassato il volume al livello " + this.volume);
		}else {
			System.out.println("Il volume è già al minimo");
		}
		
	}

}
