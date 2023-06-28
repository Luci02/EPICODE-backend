package com.epicode.esercizi;

public class Esercizio2 {
	
	public static void esercizioSwitch(int n) {
		
		switch (n) {
		case 0:
			System.out.println("ZERO");
			break;
		case 1:
			System.out.println("UNO");
			break;
		case 2:
			System.out.println("DUE");
			break;
		case 3:
			System.out.println("TRE");
			break;

		default:
			System.out.println("Il valore non è compreso tra 0 e 3");
			break;
		}
		
	}

}
