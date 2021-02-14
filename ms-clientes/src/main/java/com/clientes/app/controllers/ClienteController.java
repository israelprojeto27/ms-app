package com.clientes.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.app.dto.CreateClienteDto;
import com.clientes.app.dto.Response;
import com.clientes.app.dto.UpdateClienteDto;
import com.clientes.app.model.ClienteModel;
import com.clientes.app.service.ClienteService;
import com.clientes.app.utils.Message;

 

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	// Criar uma instancia de banco de dados para cada microsservicos (ms-produto, ms-contrato e ms-cliente)

	@Autowired
	private ClienteService service;
	
	/**
	 * 
	 * criar um Endpoint que permite a Paginacao e Ordenacao dos registros
	 * 
	 */
	
	@PostMapping("/create")
	public ResponseEntity<?> createCliente(@Valid @RequestBody CreateClienteDto dto) {
				
		try {
			service.createCliente(dto);
			Response response = new Response(null, Message.SUCESSO, HttpStatus.CREATED, Message.MSG_CLIENTE_CRIADO_SUCESSO, null);		
			return new ResponseEntity<>(response, response.getStatus());
		}
		catch(Exception e) {
			Response response = new Response(null, "erro", HttpStatus.BAD_REQUEST, Message.MSG_ERRO_GENERICO, null);
			return new ResponseEntity<>(response, response.getStatus());
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<?> listAllClientes() {		
		return new ResponseEntity<>(service.findAllClientes(), HttpStatus.OK);
	}
	
	@GetMapping("/findClienteById/{idCliente}")
	public ResponseEntity<ClienteModel> getFindClienteById(@PathVariable String idCliente) {		
		return new ResponseEntity<ClienteModel>(service.findProdutoByIdCliente(idCliente),  HttpStatus.OK);	
	}
	
	@GetMapping("/findClienteByNome/{nomeCliente}")
	public ResponseEntity<?> getFindClienteByNome(@PathVariable String nomeCliente) {		
		return new ResponseEntity<>(service.findProdutoByNomeCliente(nomeCliente),  HttpStatus.OK);	
	}
	
	@PatchMapping("/updateStatusCliente")
	public ResponseEntity<?> getupdateStatusCliente(@Valid @RequestBody UpdateClienteDto dto) {
		
		return null;
	}
}
