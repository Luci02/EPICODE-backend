package com.epicode.Spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Spring.models.Persona;

@RestController
@RequestMapping("/app")
public class MainController {

	@GetMapping("/data1")
	public Persona data1() {
		return new Persona("Mario", "Giordano", "Pesaro Urbino");
	}
	
	@GetMapping("/data2")
	public ResponseEntity<List<Persona>> data2() {
		List<Persona> listaPersone = new ArrayList<Persona>();
		listaPersone.add( new Persona("Mario", "Rossi", "Milano") );
		listaPersone.add( new Persona("Ciro", "Esposito", "Napoli") );
		listaPersone.add( new Persona("Salvatore", "Russo", "Caltanissetta") );
		return new ResponseEntity<List<Persona>>( listaPersone, HttpStatus.OK);		
	}
	
}
