package com.epicode.Spring.runners;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Edificio;
import com.epicode.Spring.models.Postazione;
import com.epicode.Spring.models.enumerated.Tipo;
import com.epicode.Spring.services.EdificioService;
import com.github.javafaker.Faker;

@Component
@Order(2)
public class PostazioneRunner implements CommandLineRunner {
	
	@Autowired EdificioService edificioService;

	@Override
	public void run(String... args) throws Exception {
		
		Faker f = new Faker(Locale.ITALY);
		Random r = new Random();
		Tipo[] tipoPostazione = Tipo.values();
		List<Edificio> listaEdifici = edificioService.FindAllEdificio();
		
		listaEdifici.forEach(edificio -> {
			for (int i = 0; i < 5; i++) {
				Postazione postazione = edificioService.creaPostazione(f.lorem().sentence(), tipoPostazione[r.nextInt(tipoPostazione.length)], r.nextInt(10, 200), edificio);
				edificioService.salvaPostazione(postazione);
			}
		});
		
		List<Postazione> listapostazioni = edificioService.findPostazioneByTipoAndCitta(Tipo.PRIVATO, "Rozzano");
		
		listapostazioni.forEach( p -> System.out.println(p) );
		
	}

}
