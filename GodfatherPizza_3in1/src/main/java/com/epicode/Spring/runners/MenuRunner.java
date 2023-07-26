package com.epicode.Spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.services.MenuService;

@Component
public class MenuRunner implements CommandLineRunner {
	
	@Autowired MenuService ms;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("***** Godfather's Pizza *****");
		ms.showMenu();
	}

}
