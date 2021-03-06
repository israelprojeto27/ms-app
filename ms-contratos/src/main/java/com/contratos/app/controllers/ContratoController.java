package com.contratos.app.controllers;

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

import com.contratos.app.dto.CreateContratoDto;
import com.contratos.app.dto.Response;
import com.contratos.app.dto.UpdateContratoDto;
import com.contratos.app.service.ContratoService;
import com.contratos.app.utils.Message;
 

@RestController
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> createContrato(@Valid @RequestBody CreateContratoDto dto) {				
		try {
			service.createContrato(dto);
			Response response = new Response(null, Message.SUCESSO, HttpStatus.CREATED, Message.MSG_CONTRATO_CRIADO_SUCESSO, null);		
			return new ResponseEntity<>(response, response.getStatus());
		}
		catch(Exception e) {
			Response response = new Response(null, "erro", HttpStatus.BAD_REQUEST, Message.MSG_ERRO_GENERICO, null);
			return new ResponseEntity<>(response, response.getStatus());
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<?> listAllContratos() {
		return new ResponseEntity<>(service.findAllContratos(), HttpStatus.OK);
	}
	
	
	@GetMapping("/findContratoByIdContrato/{IdContrato}")
	public ResponseEntity<?> findContratoByIdContrato(@PathVariable String IdContrato) {		
		return new ResponseEntity<>(service.findContratoByIdContrato(IdContrato), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/listAllContratosByIdCliente/{idCliente}")
	public ResponseEntity<?> listAllContratosByIdCliente(@PathVariable String idCliente) {		
		return new ResponseEntity<>(service.findAllContratosByIdCliente(idCliente), HttpStatus.OK);
	}
	
	@GetMapping("/listAllContratosByNomeCliente/{nomeCliente}")
	public ResponseEntity<?> getFindProdutoByNomeCliente(@PathVariable String nomeCliente) {
		
		return null;
	}
	
	@PatchMapping("/updateStatusContrato")
	public ResponseEntity<?> getupdateStatusContrato(@Valid @RequestBody UpdateContratoDto dto) {
		
		return null;
	}
}
