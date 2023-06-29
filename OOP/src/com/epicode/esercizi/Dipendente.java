package com.epicode.esercizi;

public class Dipendente {
	public static double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	public Dipendente(String matricola, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
		this.dipartimento = dipartimento;
	}
	
	public Dipendente(
			String matricola,
			double stipendio,
			double importoOrarioStraordinario,
			Livello livello,
			Dipartimento dipartimento
			) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}
	
	public String getMatricola() {
		return this.matricola;
	}
	
	public double getStipendio() {
		return this.stipendio;
	}
	
	public double getImportoOrarioStrario() {
		return this.importoOrarioStraordinario;
	}
	
	public void setImportoOrarioStrario(double imp) {
		this.importoOrarioStraordinario = imp;
	}
	
	public Livello getLivello() {
		return this.livello;
	}
	
	public Dipartimento getDipartimento() {
		return this.dipartimento;
	}
	
	public void setDipartimento(Dipartimento d) {
		this.dipartimento = d;
	}
	
	public void stampaDatiDipendente() {
		System.out.println("Dipendente matricola " 
						 + this.matricola 
						 + " Stipendio: "
						 + this.stipendio
						 + " Importo Orario Straord. "
						 + this.importoOrarioStraordinario
						 + " Livello "
						 + this.livello
						 + " Dipartimento "
						 + this.dipartimento
					);
	}
	
	public Livello promuovi() {
		
		switch (this.livello) {
		case OPERAIO:
			this.livello = Livello.IMPIEGATO;
			this.stipendio = stipendioBase * 1.2;
			break;
			
		case IMPIEGATO:
			this.livello = Livello.QUADRO;
			this.stipendio = stipendioBase * 1.5;
			break;
			
		case QUADRO:
			this.livello = Livello.DIRIGENTE;
			this.stipendio = stipendioBase * 2;
			break;

		default:
			System.out.println("ERRORE! Il Dipendente non può essere promosso");
			break;
		}
		
		return this.livello;
	}
	
	public static double calcolaPaga(Dipendente d) {
		return d.stipendio;
	}
	
	public static double calcolaPaga(Dipendente d, int oreStraord) {
		return d.stipendio + (d.importoOrarioStraordinario * oreStraord);
	}
	
}