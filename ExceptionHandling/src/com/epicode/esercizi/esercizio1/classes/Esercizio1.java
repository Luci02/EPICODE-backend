package com.epicode.esercizi.esercizio1.classes;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio1 {
	
	public void startEs1() {
		
		Scanner sc = new Scanner(System.in);
		Logger log = LoggerFactory.getLogger(Esercizio1.class);

		
//		istanzio l'array di 5 elementi
		int[] arr = new int[5];
		
//		popolo l'array con numeri da 1 a 10
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.ceil(Math.random() * 9);
			System.out.println(i+1 + ". " + arr[i]);
		}
		
		while(true) {
			
			try {
			
				System.out.println("Scrivi 0 per uscire.");
				System.out.println("Inserisci un numero da 1 a 10. Inserisci 0 per uscire");
				System.out.print(">>> ");
				int n = Integer.parseInt(sc.nextLine());
				
				if(n == 0) {
					break;
				}else if( n >= 1 && n <=10) {
					
					System.out.println("In che posizione dell'array vuoi inserire il numero? ");
					System.out.print(">>> ");
					int pos = Integer.parseInt(sc.nextLine());
					
					try {
						
						arr[pos-1] = n;
						
						for (int i = 0; i < arr.length; i++) {
							System.out.println(i+1 + ". " + arr[i]);
						}
						
					}catch(ArrayIndexOutOfBoundsException e) {
						log.error(e.getMessage());
					}
				}else {
					throw new Exception("Hai inserito un numero non concesso.");
				}
				
			}catch (NumberFormatException e) {
				log.error(e.getMessage());
			}catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
}

