package it.epicode.be;

import java.util.Scanner;

public class Helloworld {
	
	public static int moltiplica(int n1, int n2) {
		return n1 * n2;
	}
	
	public static String concatena(String str, int n) {
		return str + " " + n;
	}
	
	public static String[] inserisciInArray(String[] strArray, String str) {
		
		String[] sixElementsArray = new String[6];
		
		sixElementsArray[0] = strArray[0];
		sixElementsArray[1] = strArray[1];
		sixElementsArray[2] = str;
		sixElementsArray[3] = strArray[2];
		sixElementsArray[4] = strArray[3];
		sixElementsArray[5] = strArray[4];
		
		return sixElementsArray;
	}
	
	public static void concatenaTreStringhe() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserisci la prima stringa: ");
		String firstString = sc.nextLine();
		System.out.println("Hai inserito: " + firstString);
		
		System.out.print("Inserisci la seconda stringa: ");
		String secondString = sc.nextLine();
		System.out.println("Hai inserito: " + secondString);
		
		System.out.print("Inserisci la terza stringa: ");
		String thirdString = sc.nextLine();
		System.out.println("Hai inserito: " + thirdString);
		
		System.out.println( firstString + " " + secondString + " " + thirdString );
		System.out.println( thirdString + " " + secondString + " " + firstString );
	}
	
	public static float perimetroRettangolo(float l1, float l2) {
		return (l1 + l2) * 2;
	}
	
	public static int evenOdd( int n ) {
		if (n % 2 == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public static double perimetroTriangolo( double lato1, double lato2, double lato3 ) {
		double semiperimetro = ( lato1 + lato2 + lato3 ) / 2;
		
		return Math.sqrt( semiperimetro * (semiperimetro - lato1) * (semiperimetro - lato2) * (semiperimetro - lato3) );
	}

	public static void main (String[] args) {
	
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
//		String[] strArray = { "1", "2", "3", "4", "5" };
//		
//		for( int i = 0; i < strArray.length; i++  ) {			
//			System.out.println(strArray[i]);
//		}
//		
//		String[] sixElementsArray = inserisciInArray(strArray, "stringa aggiunta");
//		
//		for( int i = 0; i < sixElementsArray.length; i++  ) {			
//			System.out.println(sixElementsArray[i]);
//		}
		
//		concatenaTreStringhe();
		
		System.out.println( evenOdd(3) );
		
		System.out.println( perimetroTriangolo(6, 6, 8) );
	}
}