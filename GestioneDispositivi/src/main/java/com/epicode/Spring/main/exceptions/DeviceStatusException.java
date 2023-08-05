package com.epicode.Spring.main.exceptions;

import org.springframework.http.HttpStatus;

public class DeviceStatusException extends RuntimeException {
	
	private static final long serialVersionUID = 6970996421323702353L;
	private HttpStatus status;

	public DeviceStatusException( String message, HttpStatus status ) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
}
