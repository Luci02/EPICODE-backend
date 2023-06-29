package com.epicode.esercitazione.serale;

public class Esercizio1 {
	
	static boolean stringaPariDispari(String str) {
		
		if(str.length()%2 == 0) {
			System.out.print("\"" + str + "\"" + " è lunga " + str.length() + " caratteri.");
			System.out.print("(true) ");
			return true;
		}
		
		System.out.print("\"" + str + "\"" + " è lunga " + str.length() + " caratteri.");
		System.out.print("(false) ");
		return false;
	}
	
	static boolean annoBisestile(int anno) {
		
		System.out.print("L\'anno " + anno + " è bisestile? ");
		
		if( (anno%100 == 0) && (anno%400 == 0) ) {
			return true;
		}else if( anno%4 == 0 ) {
			return true;
		}
		
		return false;
	}

}
