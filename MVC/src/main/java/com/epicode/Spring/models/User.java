package com.epicode.Spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public String name;
	public String surname;
	public String username;
	public String numTel;
	
	public User(String name, String surname, String username, String numTel) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.numTel = numTel;
	}

}
