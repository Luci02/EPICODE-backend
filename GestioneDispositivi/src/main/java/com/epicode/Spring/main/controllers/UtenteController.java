package com.epicode.Spring.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Spring.main.models.Utente;
import com.epicode.Spring.main.services.UtenteService;

@RestController
@RequestMapping("/api")
public class UtenteController {
	
	@Autowired UtenteService utenteSvc;
	
	@GetMapping("/users")
	public ResponseEntity<List<Utente>> getallUsers() {
		List<Utente> listaUtenti = utenteSvc.getAllUsers();
		ResponseEntity<List<Utente>> response = new ResponseEntity<List<Utente>>(listaUtenti, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/users/{username}")
	public ResponseEntity<Utente> getSingleUser( @PathVariable String username ) {
		return new ResponseEntity<Utente>( utenteSvc.getSingleUser(username), HttpStatus.OK );
	}
	
	@PostMapping("/users")
	public ResponseEntity<Utente> setNewUser( @RequestBody Utente utente ) {
		utenteSvc.saveUser(utente);
		return new ResponseEntity<Utente>( utente, HttpStatus.OK );
	}
	
	@PutMapping("/users")
	public ResponseEntity<Utente> updateUser( @RequestBody Utente utente ) {
		utenteSvc.updateUser(utente);
		return new ResponseEntity<Utente>( utente, HttpStatus.OK );
	}
	
	@DeleteMapping("/users/{username}")
	public ResponseEntity<String> deleteUser( @PathVariable String username ) {		
		utenteSvc.deleteUser(username);
		return new ResponseEntity<String>("Utente eliminato correttamente dal DB!", HttpStatus.OK);
	}

}
