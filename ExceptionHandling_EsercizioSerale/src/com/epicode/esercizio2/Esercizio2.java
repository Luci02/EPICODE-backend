package com.epicode.esercizio2;

import java.util.Scanner;

public class Esercizio2 {
	
	public static void start() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
						
			try {
				
				System.out.print("Inserisci il numero di chilometri percorsi: ");
				int km = Integer.parseInt(sc.nextLine());
				
				if(km == 0) {
					throw new Exception("Non hai percorso chilometri.");
				}
				
				System.out.print("Inserisci il numero di litri consumati: ");
				int lt = Integer.parseInt(sc.nextLine());
				
				if(lt == 0) {
					throw new ArithmeticException("Stai cercando di dividere per zero!");
				}
				
				int kmLt = km / lt;
				
				System.out.println("Hai percorso " + kmLt + "Km con un litro.");

			}catch(ArithmeticException e) {
				System.out.println(e.getMessage());
				break;
			}catch (Exception e) {
				System.out.println(e.toString());
			}
			
		}
		
	}

}
