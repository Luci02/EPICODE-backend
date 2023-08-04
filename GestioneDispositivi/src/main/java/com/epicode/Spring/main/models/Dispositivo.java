package com.epicode.Spring.main.models;

import com.epicode.Spring.main.models.enumerators.StatoDispositivo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "dispositivi")
public abstract class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Utente utente;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "stato")
	private StatoDispositivo statoDispositivo;

	public Dispositivo() {
		super();
		this.statoDispositivo = StatoDispositivo.DISPONIBILE;
	}
	
}
