package com.epicode.Spring.models;

import jakarta.persistence.Column;
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
@Table(name = "utenti")
public class Utente {

	@Id
	private String username;
	
	@Column(name = "nome_completo")
	private String nomeCompleto;
	
	@Column(unique = true)
	private String email;
	
}
