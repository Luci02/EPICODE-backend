package com.epicode.Spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.services.UserService;

@Component
public class UserRunner implements CommandLineRunner {
	
	@Autowired UserService userService;

	@Override
	public void run(String... args) throws Exception {
		
		userService.saveUser(5);
		
	}

}
