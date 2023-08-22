package com.epicode.Spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/os")
public class MainController {

	@GetMapping("/get-string")
	public String getString() {
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> response = rt.getForEntity("http://localhost:8082/app/data1", String.class);
		return response.getBody();
	}
	
	@GetMapping("/get-people")
	public Object getPeople() {
		RestTemplate rt = new RestTemplate();
		
		return new ResponseEntity<Object>(rt.getForObject("http://localhost:8082/app/data2", Object.class), HttpStatus.OK);
	}
	
}
