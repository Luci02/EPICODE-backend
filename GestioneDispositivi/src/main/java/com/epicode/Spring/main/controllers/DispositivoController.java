package com.epicode.Spring.main.controllers;

import org.hibernate.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Spring.main.models.Dispositivo;
import com.epicode.Spring.main.models.Laptop;
import com.epicode.Spring.main.models.Smartphone;
import com.epicode.Spring.main.models.Tablet;
import com.epicode.Spring.main.models.enumerators.StatoDispositivo;
import com.epicode.Spring.main.services.DispositivoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/devices")
public class DispositivoController {
	
	@Autowired DispositivoService dispSvc;
	
	@GetMapping
	public ResponseEntity<Page<Dispositivo>> getAllDevices( Pageable pageable ) {
		return new ResponseEntity<Page<Dispositivo>>(dispSvc.getAllDevices(pageable), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Dispositivo> addNewDevice( @PathParam(value = "type") String type ) {
		
		Dispositivo d = null;
		
		if (type.equals("smartphone")) {			
			Smartphone s = dispSvc.createSmartphone();
			d = s;
			dispSvc.saveDevice(s);
		}else if( type.equals("tablet") ) {
			Tablet t = dispSvc.createTablet();
			d = t;
			dispSvc.saveDevice(t);
		}else if( type.equals("laptop") ) {
			Laptop l = dispSvc.createlapLaptop();
			d = l;
			dispSvc.saveDevice(l);
		}else {
			throw new TypeMismatchException("Il dispositivo che stai cercando di creare non esiste!");
		}
		
		return new ResponseEntity<Dispositivo>(d, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dispositivo> modifyDeviceStatus( 
							@PathVariable Long id, 
							@PathParam(value = "status") StatoDispositivo status 
	) {
		return new ResponseEntity<Dispositivo>(dispSvc.changeDeviceStatus(id, status), HttpStatus.OK);
	}
	
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> assingUserToDevice( @PathVariable Long id, @PathParam(value = "username") String username ) {
		return new ResponseEntity<String>(dispSvc.setDeviceUser(id, username), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Dispositivo> deleteDevice( @PathVariable Long id ) {
		return new ResponseEntity<Dispositivo>( dispSvc.deleteDeviceById(id), HttpStatus.OK );
	}

}
