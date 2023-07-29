package com.epicode.Spring.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class PrenotazioneRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {}

}
