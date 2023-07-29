package com.epicode.Spring.models;

import com.epicode.Spring.models.enumerated.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "postazioni")
public class Postazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codice_univoco")
	private Long id;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Column(name = "num_max_occupanti")
	private int maxNumOccupanti;
	
	@ManyToOne
	private Edificio edificio;

	public Postazione(String descrizione, Tipo tipo, int maxNumOccupanti, Edificio edificio) {
		super();
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.maxNumOccupanti = maxNumOccupanti;
		this.edificio = edificio;
	}

}
