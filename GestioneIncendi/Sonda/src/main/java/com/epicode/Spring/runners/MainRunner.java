package com.epicode.Spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.models.Sonda;
import com.epicode.Spring.services.SondaService;

@Component
public class MainRunner implements CommandLineRunner {
	
	@Autowired SondaService sondaSvc;

	@Override
	public void run(String... args) throws Exception {
		
		//sondaSvc.save("38.24976", "-14.52208");
		//sondaSvc.save("-45.89038", "106.51930");
		sondaSvc.save("-10.73441", "44.48261");
		sondaSvc.save("-26.75746", "142.57689");
		sondaSvc.save("12.25874", "10.26139");
		sondaSvc.save("36.91753", "-19.59881");
		sondaSvc.save("-17.81717", "-36.83442");
		sondaSvc.save("-40.00293", "117.22012");
		sondaSvc.save("32.06210", "67.87444");
		
		//Sonda s1 = sondaSvc.find(1l);
		//sondaSvc.sendRequest(s1);
	}

	
	
}
