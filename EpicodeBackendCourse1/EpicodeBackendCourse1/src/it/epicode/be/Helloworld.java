package it.epicode.be;

import java.util.Scanner;

public class Helloworld {
	
	public static int moltiplica(int n1, int n2) {
		return n1 * n2;
	}
	
	public static String concatena(String str, int n) {
		return str+ " " + n;
	}
	
	public static void inserisciInArray(String[] strArray, String str) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserisci qualcosa: ");
		String nome = sc.nextLine();
		System.out.println(nome);
	}

	public static void main (String[] args) {
	
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		String[] strArray = { "1", "2", "3", "4", "5" };
		
		for( int i = 0; i < strArray.length; i++  ) {			
			System.out.println(strArray[i]);
		}
		
		
	}
}