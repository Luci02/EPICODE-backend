package com.sys.inf;

public class SIMCard {
	
	int numero;
	double credito = 0;
	Chiamata[] listaChiamate = new Chiamata[5];
	
	public SIMCard(int num) {
		this.numero = num;
	}
	
	public void stampaDatiSIM() {
		System.out.println( "Il tuo numero di telefono: " + numero );
		System.out.println( "Il tuo credito disponibile è: " + credito + "€\n\n" );
		
		this.listaChiamate[0] = new Chiamata(5, 111111111);
		
		System.out.println( "---------Lista Ultime 5 Chiamate--------------" );
		for (int i = 0; i < listaChiamate.length; i++) {
			
			if (listaChiamate[i] != null) {
				System.out.println( listaChiamate[i].numeroChiamato + ": " + listaChiamate[i].durata + " min" );				
			} else {
				System.out.println( "Chiamata non ancora effettuata" );
			}
		}
		
	}

}
