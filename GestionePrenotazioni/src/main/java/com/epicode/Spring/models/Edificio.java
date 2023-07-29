package com.epicode.Spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "edifici")
public class Edificio {

	@Id
	private String nome;
	
	private String indirizzo;
	
	private String citta;
	
	
	
}