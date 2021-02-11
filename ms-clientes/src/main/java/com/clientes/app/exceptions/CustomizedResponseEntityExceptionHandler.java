package com.clientes.app.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.clientes.app.dto.Response;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@Override 
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Response response = new Response(null, "erro",HttpStatus.BAD_REQUEST , "Erro na validacao", ex.getBindingResult().getFieldErrors());	        
        return handleExceptionInternal(ex, response, headers, response.getStatus(), request);
    }
	  
	
	@ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Response> handleNotFoundException(DataNotFoundException ex, WebRequest request) {
              
		Response response = new Response(null, "erro",HttpStatus.NOT_FOUND , ex.getMessage(), null);
        return new ResponseEntity<Response>(response, response.getStatus());
    }
	  
}