package com.epicode.Spring.main.configurations;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.main.models.Utente;
import com.github.javafaker.Faker;

@Configuration
public class UtenteConfiguration {

	@Bean("getFakeUser")
	@Scope("prototype")
	public Utente getFakeUser() {
		Faker f = new Faker(Locale.ITALY);
		String name = f.name().firstName();
		String surname = f.name().lastName();
		return Utente.builder()
				.username((name+"_"+surname).toLowerCase())
				.nome(name)
				.cognome(surname)
				.email( (name+"."+surname+"@mail.com").toLowerCase() )
				.build();
	}
	
}
