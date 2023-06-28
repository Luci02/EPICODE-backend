package com.epicode.esercizi;

public class Esercizio1 {
	
	public static boolean stringaPariDispari(String str) {
		
		if( str.length()%2 == 0 ) {
			return true;
		}

		return false;
	}
	
	public static boolean annoBisestile(int anno) {
		
		if( (anno%100 == 0) && (anno%400 == 0) ) {
			return true;
		}else if( anno%4 == 0 ) {
			return true;
		}
		
		return false;
	}

}
