package com.epicode.esercizio3;

public class Presenza {
	
	private String nomeDipendente;
	private int giorniDiPresenza;
	
	public Presenza(String nomeDipendente, int giorniDiPresenza) {
		this.nomeDipendente = nomeDipendente;
		this.setGiorniDiPresenza(giorniDiPresenza);
	}

	public String getNomeDipendente() {
		return nomeDipendente;
	}

	public int getGiorniDiPresenza() {
		return giorniDiPresenza;
	}

	public void setGiorniDiPresenza(int giorniDiPresenza) {
		this.giorniDiPresenza = giorniDiPresenza;
	}
	
	@Override
	public String toString() {
		return "Presenze [nome=" + nomeDipendente + ", numPresenze=" + giorniDiPresenza + "]";
	}

}
