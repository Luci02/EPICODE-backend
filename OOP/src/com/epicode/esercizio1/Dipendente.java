package com.epicode.esercizio1;

public class Dipendente {
	
	public double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello Livello;
	private Dipartimento Dipartimento;
	
	public Dipendente(String matricola, Dipartimento dip) {
		this.matricola = matricola;
		this.stipendio = this.stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.Livello = Livello.OPERAIO;
		this.Dipartimento = dip;
	}
	
	public Dipendente(
			String matricola, 
			double stipendio, 
			double importoOrarioStraordinario, 
			Livello Livello, 
			Dipartimento Dipartimento
		) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.Livello = Livello;
		this.Dipartimento = Dipartimento;
	}

	public double getStipendio() {
		return this.stipendio;
	}
	
	public double getImportoOrarioStraordinario() {
		return this.importoOrarioStraordinario;
	}
	
	public void setImportoOrarioStraordinario(double i) {
		this.importoOrarioStraordinario = i;
	}
	
	public Livello getLivello() {
		return this.Livello;
	}
	
	public Dipartimento getDipartimento() {
		return this.Dipartimento;
	}
	
	public void setDipartimento(Dipartimento d) {
		this.Dipartimento = d;
	}
	
	public void stampaDatiDipendente() {
		System.out.println("Matrica: " + this.matricola);
		System.out.println("Stipendio: " + this.stipendio);
		System.out.println("Importo Orario Straordio: " + this.importoOrarioStraordinario);
		System.out.println("Livello: " + this.Livello);
		System.out.println("Dipartimento: " + this.Dipartimento);
	}
}
