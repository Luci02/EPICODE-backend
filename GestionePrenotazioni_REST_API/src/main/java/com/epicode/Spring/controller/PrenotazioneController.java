package com.epicode.Spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class PrenotazioneController {

	@GetMapping("/it")
	public ResponseEntity<String> infoIT() {
		return new ResponseEntity<String>("Informazioni in italiano.", HttpStatus.OK) ;
	}
	
	@GetMapping("/en")
	public ResponseEntity<String> infoEN() {
		return new ResponseEntity<String>("English informations.", HttpStatus.OK) ;
	}
	
}
