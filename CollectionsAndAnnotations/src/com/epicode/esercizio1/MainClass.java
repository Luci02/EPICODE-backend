package com.epicode.esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MainClass.class);
	
	public static void main(String[] args) {
		
		start();

	}
	
	private static void start() {
		
		Scanner sc = new Scanner(System.in);
		
		Set<String> paroleDistinte = new HashSet<String>();
		Set<String> paroleDuplicate = new HashSet<String>();
		
		try {
			System.out.print("Digita il numero di elementi da inserire: ");
			int n = Integer.parseInt(sc.nextLine());
			
			for (int i = 0; i < n; i++) {
				System.out.print("Inserisci la parola n." + (i+1) + ": ");
				String elem = sc.nextLine();
				
				if( !paroleDistinte.contains(elem) ) {				
					paroleDistinte.add(elem);
				}else {
					paroleDuplicate.add(elem);
				}
			}
			
			if( !paroleDuplicate.isEmpty() ) {				
				log.info( "Parole duplicate: " + paroleDuplicate.toString() );
			}else {
				log.info("Non ci sono parole duplicate");
			}
			
			log.info( "Numero di parole distinte: " + paroleDistinte.size() );
			log.info( "Parole distinte: " + paroleDistinte.toString() );
			
		} catch (NumberFormatException e) {
			log.error("Inserisci il tipo di dato corretto!");
		}
	}

}
