package com.epicode.esercizio1.classes;

import java.util.Random;
import java.util.Scanner;

public class Esercizio1 {
	
	public static void start() {
		
		int[] arr = generaArray(5);
		
		Scanner sc = new Scanner(System.in);

		stampaArray(arr);
			
		while(true) {
			try {
			
				System.out.print("Inserisci un numero da 1 a 10, oppure 0 per uscire: ");
				int n = Integer.parseInt(sc.nextLine());
				System.out.println();
				
				if(n == 0) {
					break;
				}else if(n < 1 || n > 10) {
					throw new Exception("Hai inserito un numero non consentito! Inserisci un numero da 1 a 10.");
				}
				
				System.out.print("Inserisci la posizione in cui desideri inserire il numero: ");
				int posizione = Integer.parseInt(sc.nextLine());
				
				modificaArray(arr, n, posizione);
				
				stampaArray(arr);
			
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("Errore: Inserisci il tipo di dato corretto.");
				System.out.println();
			} catch(IndexOutOfBoundsException e) {
				System.out.println();
				System.out.println("Stai cercando di inserire il numero in una posizione inesistente!");
				System.out.println();
			}catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
			
		
	}

	private static int[] generaArray(int arrLength) {
		
		int[] arr = new int[arrLength];
		
		Random r = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(10) + 1;
		}
		
		return arr;
		
	}
	
	private static void stampaArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i+1) + ". " + arr[i]);
		}
		System.out.println();
	}
	
	private static int[] modificaArray(int[] arr, int numToReplace, int posizione) {
		arr[posizione-1] = numToReplace;
		
		return arr;
	}
	
}
