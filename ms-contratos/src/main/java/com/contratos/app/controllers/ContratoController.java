package com.contratos.app.controllers;

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

import com.contratos.app.dto.CreateContratoDto;
import com.contratos.app.dto.UpdateContratoDto;
import com.contratos.app.service.ContratoService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> createContrato(@Valid @RequestBody CreateContratoDto dto) {
				
		return null;
	}
	
	@GetMapping("/listAllContratosByIdCliente/{idCliente}")
	public ResponseEntity<?> listAllContratosByIdCliente(@PathVariable String idCliente) {
		
		return null;
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
