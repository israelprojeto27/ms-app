package com.clientes.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeanNotFoundException  extends RuntimeException {
 
	private static final long serialVersionUID = -3894620025497891784L;

	public BeanNotFoundException(String message) {
		super(message);
	}
}
