package com.epicode.Spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.services.OrdineService;

@Component
public class OrdineRunner implements CommandLineRunner {

	@Autowired OrdineService os;
	
	@Override
	public void run(String... args) throws Exception {
		//os.newOrder();
	}

}
