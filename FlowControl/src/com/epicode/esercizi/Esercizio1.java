package com.epicode.esercizi;

class Esercizio1 {
	
	static boolean stringaPariDispari(String str) {
		
		if( str.length()%2 == 0 ) {
			return true;
		}

		return false;
	}
	
	static boolean annoBisestile(int anno) {
		
		if( (anno%100 == 0) && (anno%400 == 0) ) {
			return true;
		}else if( anno%4 == 0 ) {
			return true;
		}
		
		return false;
	}

}
