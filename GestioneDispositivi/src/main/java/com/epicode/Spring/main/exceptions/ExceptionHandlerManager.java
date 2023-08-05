package com.epicode.Spring.main.exceptions;

import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;

@ControllerAdvice
public class ExceptionHandlerManager extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<String> manageEntityExistsException(EntityExistsException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DeviceStatusException.class)
	public ResponseEntity<String> manageEqualStatusException(DeviceStatusException e) {
		return new ResponseEntity<String>(e.getMessage(), e.getStatus());
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public ResponseEntity<String> manageTypeMismatchException( TypeMismatchException e ) {
		return new ResponseEntity<String>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
	}
	
}
