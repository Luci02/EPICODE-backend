package com.epicode.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name = "utenti")
public class Utente {

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(name = "data_di_nascita", nullable = false)
	private LocalDate dataDiNascita;
	
	@Id
	@Column(unique = true)
	String numeroDiTessera;
	
	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, LocalDate dataDiNascita, String numeroDiTessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTessera = numeroDiTessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getNumeroDiTessera() {
		return numeroDiTessera;
	}

	public void setNumeroDiTessera(String numeroDiTessera) {
		this.numeroDiTessera = numeroDiTessera;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", numeroDiTessera=" + numeroDiTessera + "]";
	}
	
}
