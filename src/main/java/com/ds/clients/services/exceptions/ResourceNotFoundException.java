package com.ds.clients.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
