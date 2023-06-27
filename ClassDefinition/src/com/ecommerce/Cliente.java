package com.ecommerce;
import java.util.Date;

public class Cliente {
	
	int codCli;
	String nome, cognome, email, subscriptionDate;  
	
	public Cliente (
			int cod,
			String nome,
			String cognome,
			String email) {
		this.codCli = cod;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.subscriptionDate = new Date().toString();
	}
}
