package com.epicode.Spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tavolo {
	
	private Integer numeroTavolo;
	private Integer numeroCopertiMassimi;
	private boolean isEmpty = true;
	
	public Tavolo(Integer numeroTavolo, Integer numeroCopertiMassimi) {
		super();
		this.numeroTavolo = numeroTavolo;
		this.numeroCopertiMassimi = numeroCopertiMassimi;
	}
	
	

}
