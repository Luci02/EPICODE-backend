package com.epicode.Spring.runners;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Edificio;
import com.epicode.Spring.services.EdificioService;
import com.github.javafaker.Faker;

@Component
@Order(1)
public class EdificioRunner implements CommandLineRunner {
	
	@Autowired EdificioService edificioService;

	@Override
	public void run(String... args) throws Exception {
	
		Faker f = new Faker(Locale.ITALY);
		
		for (int i = 0; i < 5; i++) {
			Edificio edificio = edificioService.creaEdificio(f.company().name(), f.address().fullAddress(), f.address().cityName());
			edificioService.salvaEdificio(edificio);
		}
		
		Edificio edificio = edificioService.creaEdificio(f.company().name(), f.address().fullAddress(), "Rozzano");
		edificioService.salvaEdificio(edificio);
		
	}

}
