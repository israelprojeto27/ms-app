package com.clientes.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.app.dto.CreateClienteDto;
import com.clientes.app.dto.UpdateClienteDto;
import com.clientes.app.service.ClienteService;
 

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> createCliente(@Valid @RequestBody CreateClienteDto dto) {
				
		return null;
	}
	
	@GetMapping("/findClienteById/{idCliente}")
	public ResponseEntity<?> getFindClienteById(@PathVariable String idCliente) {
		
		return null;
	}
	
	@GetMapping("/findClienteByNome/{nomeCliente}")
	public ResponseEntity<?> getFindClienteByNome(@PathVariable String nomeCliente) {
		
		return null;
	}
	
	@PatchMapping("/updateStatusCliente")
	public ResponseEntity<?> getupdateStatusCliente(@Valid @RequestBody UpdateClienteDto dto) {
		
		return null;
	}
}
