package com.ecommerce;

public class Articolo {
	
	String codArt;
	String descArt;
	double prezzo;
	int qta;
	
	public Articolo( String codArt, String descArt, double prezzo, int qta ) {
		this.codArt = codArt;
		this.descArt = descArt;
		this.prezzo= prezzo;
		this.qta = qta;
	}

}
