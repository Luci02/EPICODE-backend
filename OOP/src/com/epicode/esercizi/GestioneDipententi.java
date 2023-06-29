package com.epicode.esercizi;

public class GestioneDipententi {

	public static void main(String[] args) {
		
		Dipendente prod1 = new Dipendente("N.00001", Dipartimento.PRODUZIONE);
		Dipendente prod2 = new Dipendente("N.00002", Dipartimento.PRODUZIONE);
		
		Dipendente impiegato = new Dipendente("N.00003", 1250, 40, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		
		Dipendente dirigente = new Dipendente("N.00004", 5000, 100, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
//		promuovo l'operaio a impiegato
		System.out.println(prod1.getLivello() + " primosso a " + prod1.promuovi());
		
//		promuovo l'impiegato a quadro
		System.out.println(impiegato.getLivello() + " primosso a " + impiegato.promuovi());
		
//		stampo lo stato di tutti i dipendenti
		prod1.stampaDatiDipendente();
		prod2.stampaDatiDipendente();
		impiegato.stampaDatiDipendente();
		dirigente.stampaDatiDipendente();
		
		System.out.println(
				Dipendente.calcolaPaga(prod1, 5)
				+ Dipendente.calcolaPaga(prod2, 5)
				+ Dipendente.calcolaPaga(impiegato, 5)
				+ Dipendente.calcolaPaga(dirigente, 5)
			);
	}

}