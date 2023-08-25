package com.epicode.Spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Sonda;
import com.epicode.Spring.repositories.SondaRepository;
import com.epicode.Spring.services.SondaService;

@Component
public class MainRunner implements CommandLineRunner {
	
	@Autowired SondaRepository sondaRepo;
	@Autowired SondaService sondaSvc;

	@Override
	public void run(String... args) throws Exception {
		
		//Sonda s = new Sonda("38.24976", "-14.52208");
		//Sonda s = new Sonda("-45.89038", "106.51930");
		//sondaRepo.save(s);
		
		Sonda s1 = sondaRepo.findById(2l).get();
		sondaSvc.sendRequest(s1);
	}

	
	
}
