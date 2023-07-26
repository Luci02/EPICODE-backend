package com.epicode.Spring.models;

import java.time.LocalTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@PropertySource("classpath:application.properties")
public class Ordine {
	
	@Value("costo.coperto") private Double costoCoperto;

	private Integer numeroOrdine;
	private Tavolo tavolo;
	private List<Consumabile> ordineTavolo;
	private String nota;
	private Stato stato;
	private Integer numeroCoperti;
	private LocalTime oraAquisizione;
	private Double importoTotale;
	
	public Ordine(Integer numeroOrdine, Tavolo tavolo, List<Consumabile> ordineTavolo, Stato stato,
			Integer numeroCoperti, LocalTime oraAquisizione) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.tavolo = tavolo;
		this.ordineTavolo = ordineTavolo;
		this.stato = stato;
		this.numeroCoperti = numeroCoperti;
		this.oraAquisizione = oraAquisizione;
		
		for (Consumabile consumabile : ordineTavolo) {
			this.importoTotale += consumabile.getPrezzo();
		}
		
		this.importoTotale += costoCoperto * numeroCoperti;
	}

	public Ordine(Integer numeroOrdine, Tavolo tavolo, List<Consumabile> ordineTavolo, String nota,
			Stato stato, Integer numeroCoperti, LocalTime oraAquisizione) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.tavolo = tavolo;
		this.ordineTavolo = ordineTavolo;
		this.nota = nota;
		this.stato = stato;
		this.numeroCoperti = numeroCoperti;
		this.oraAquisizione = oraAquisizione;
		
		for (Consumabile consumabile : ordineTavolo) {
			this.importoTotale += consumabile.getPrezzo();
		}
		
		this.importoTotale += costoCoperto * numeroCoperti;
	}

}
