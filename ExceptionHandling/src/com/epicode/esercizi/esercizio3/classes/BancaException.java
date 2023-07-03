package com.epicode.esercizi.esercizio3.classes;

public class BancaException extends Exception {

	public BancaException(String message) {
		super(message);
	}
	
	@Override
	public String toString(){
		return this.getMessage();
	}

}
