package com.epicode.esercizi.esercizio2.classes;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio2 {
	
	public static void start() {
		
		Scanner sc = new Scanner(System.in);
		Logger log = LoggerFactory.getLogger(Esercizio2.class);
		
		try {
			
			System.out.print("Inserisci il numero di Km percorsi: ");
			int km = Integer.parseInt(sc.nextLine());
			
			System.out.print("Inserisci i litri di carburante consumati: ");
			int lt = Integer.parseInt(sc.nextLine());
			
			int kmPerLt = km / lt;
			
			log.info("Hai consumato " + kmPerLt + "Km per litro");
			
		} catch (ArithmeticException e) {
			log.error("ERRORE! Non puoi dividere per zero!");
		}
	}

}
