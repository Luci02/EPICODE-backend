package com.epicode.Spring.models;

import java.time.LocalTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Data
public class Ordine {

	private Integer numeroOrdine;
	private Tavolo tavolo;
	private List<Consumabile> ordineTavolo;
	private String nota;
	private Stato stato;
	private Integer numeroCoperti;
	private LocalTime oraAquisizione;
	private Double importoTotale;
	private Double costoCoperto;

}
