package com.epicode.Spring.main.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.Spring.main.services.UtenteService;

@Component
@Order(1)
public class UtenteRunner implements CommandLineRunner {

	@Autowired UtenteService utenteService;
	
	@Override
	public void run(String... args) throws Exception {
		
//		for (int i = 0; i < 5; i++) {
//			utenteService.saveUser( utenteService.createFakeUser() );
//		}
		
	}
	
}
