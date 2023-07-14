package com.epicode.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persone")
public class Persona {

	@Id
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(name = "email", nullable = false)
	private String Email;
	
	@Column(name = "data_di_nascita", nullable = false)
	private LocalDate dataDiNascita;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Sesso sesso;
	
	@Column(name="lista_partecipazioni", nullable = false)
	private List<Object> listaPartecipazioni;
	
	public Persona() {
		super();
	}

	public Persona(long id, String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso,
			List<Object> listaPartecipazioni) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		Email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.listaPartecipazioni = listaPartecipazioni;
	}
	
	public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso,
			List<Object> listaPartecipazioni) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		Email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.listaPartecipazioni = listaPartecipazioni;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public List<Object> getListaPartecipazioni() {
		return listaPartecipazioni;
	}

	public void setListaPartecipazioni(List<Object> listaPartecipazioni) {
		this.listaPartecipazioni = listaPartecipazioni;
	}
	
}
