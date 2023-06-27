package com.rectangle;

public class Rettangolo {
	
	int base;
	int altezza;
	
	public Rettangolo(int base, int altezza) {
		
		this.base = base;
		this.altezza = altezza;
		
	}
	
	int calcolaPerimetro() {
		return (base + altezza) * 2;
	}
	
	int calcolaArea() {
		return base * altezza;
	}
	
	static void stampaRettangolo( Rettangolo rettangolo ) {
		System.out.println( "Perimetro: " + rettangolo.calcolaPerimetro() + "cm" );
		System.out.println( "Area: " + rettangolo.calcolaArea() + "cm2" );	
	}
	
	static void stampaDueRettangoli( Rettangolo r1, Rettangolo r2 ) {
		System.out.println( "----------------Dati primo rettangolo----------------" );
		System.out.println( "Perimetro: " + r1.calcolaPerimetro() + "cm" );
		System.out.println( "Area: " + r1.calcolaArea() + "cm2" );
		System.out.println( "----------------------------------------------------- \n" );
		
		System.out.println( "--------------Dati secondo rettangolo----------------" );
		System.out.println( "Perimetro: " + r2.calcolaPerimetro() + "cm" );
		System.out.println( "Area: " + r2.calcolaArea() + "cm2" );
		System.out.println( "----------------------------------------------------- \n" );
		
		System.out.println( "--------------Somma Perimetro e Area-----------------" );
		System.out.println( "Somma dei due perimetri: " + ( r1.calcolaPerimetro() + r2.calcolaPerimetro() ) + "cm" );
		System.out.println( "Somma delle due aree: " + ( r1.calcolaArea() + r2.calcolaArea() ) + "cm2" );
		System.out.println( "----------------------------------------------------- \n" );
	}

}