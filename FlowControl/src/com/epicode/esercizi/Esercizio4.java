package com.epicode.esercizi;

import java.util.Scanner;

class Esercizio4 {
	
	static void esercizioFor() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un numero: ");
		int n = sc.nextInt();
		
		for (int i = n; i >= 0 ; i--) {
			System.out.println(i);
		}		
	}

}
