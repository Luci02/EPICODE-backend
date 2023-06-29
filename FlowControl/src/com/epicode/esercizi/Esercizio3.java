package com.epicode.esercizi;

import java.util.Scanner;

class Esercizio3 {

	static void esercizioWhile() {
		
		Scanner sc = new Scanner(System.in);
		String stringaInserita;
		
		do {
			System.out.print("Inserisci una stringa: ");
			stringaInserita = sc.nextLine();
			String[] strArray = stringaInserita.split("");

			System.out.println(strArray.toString().join(",", strArray));
			
			System.out.println("Hai digitato: " + stringaInserita);
		} while (!stringaInserita.equals(":q"));
		
		System.out.println("Hai digitato \":q\" e sei uscito dal ciclo ");
		
	} 

}