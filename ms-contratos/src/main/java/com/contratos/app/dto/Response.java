package com.contratos.app.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Response {
		
	private HttpStatus status; 
	private String tipo;
	private String message;
	
	/*@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDateTime dateResponse;*/
	  
	private Object entity;
	private List<ErrorResponse> errors = null;	
	

	public Response(Object obj, String tipo, HttpStatus status, String mensagem, List<FieldError> list) {
		this.entity = obj;
		this.tipo = tipo;
		this.status = status;
		this.message = mensagem;		
		if (list != null && ! list.isEmpty()) {
			this.errors = new ArrayList<ErrorResponse>();
			for (FieldError error : list) {
				ErrorResponse errorResponse = new ErrorResponse(error.getField(), error.getDefaultMessage());			
				this.errors.add(errorResponse);
			}	
		}		
	}

}
