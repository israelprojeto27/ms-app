package com.produtos.app.controllers;

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

import com.produtos.app.dto.CreateProdutoDto;
import com.produtos.app.dto.UpdateProdutoDto;
import com.produtos.app.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduto(@Valid @RequestBody CreateProdutoDto dto) {
				
		return null;
	}
	
	@GetMapping("/findProdutoById/{idProduto}")
	public ResponseEntity<?> getFindProdutoById(@PathVariable String idProduto) {
		
		return null;
	}
	
	@GetMapping("/findProdutoByNome/{nomeProduto}")
	public ResponseEntity<?> getFindProdutoByNomeProduto(@PathVariable String nomeProduto) {
		
		return null;
	}
	
	@PatchMapping("/updateStatusProduto")
	public ResponseEntity<?> getupdateStatusProduto(@Valid @RequestBody UpdateProdutoDto dto) {
		
		return null;
	}

}
