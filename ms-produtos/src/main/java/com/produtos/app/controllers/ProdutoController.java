package com.produtos.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.app.dto.CreateProdutoDto;
import com.produtos.app.dto.Response;
import com.produtos.app.dto.UpdateProdutoDto;
import com.produtos.app.model.ProdutoModel;
import com.produtos.app.service.ProdutoService;
import com.produtos.app.utils.Message;



@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	/**
	 * 
	 * criar um Endpoint que permite a Paginacao e Ordenacao dos registros
	 * 
	 */
	
	@Value("${test.config}")
	private String testConfig;
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduto(@Valid @RequestBody CreateProdutoDto dto) {
		try {
			service.createProduto(dto);
			Response response = new Response(null, Message.SUCESSO, HttpStatus.CREATED, Message.MSG_PRODUTO_CRIADO_SUCESSO, null);		
			return new ResponseEntity<>(response, response.getStatus());
		}
		catch(Exception e) {
			Response response = new Response(null, "erro", HttpStatus.BAD_REQUEST, Message.MSG_ERRO_GENERICO, null);
			return new ResponseEntity<>(response, response.getStatus());
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<?> listAllProdutos() {
		System.out.println("Test config value: " + testConfig);
		return new ResponseEntity<>(service.findAllProdutos(), HttpStatus.OK);
	}
	
	@GetMapping("/findProdutoById/{idProduto}")
	public ResponseEntity<ProdutoModel> getFindProdutoById(@PathVariable String idProduto) {
		return new ResponseEntity<ProdutoModel>(service.findProdutoByIdProduto(idProduto),  HttpStatus.OK);	
	}
	
	@GetMapping("/findProdutoByNome/{nomeProduto}")
	public ResponseEntity<?> getFindProdutoByNomeProduto(@PathVariable String nomeProduto) {		
		return new ResponseEntity<>(service.findProdutoByNomeProduto(nomeProduto),  HttpStatus.OK);	
	}
	
	@PatchMapping("/updateStatusProduto")
	public ResponseEntity<?> getupdateStatusProduto(@Valid @RequestBody UpdateProdutoDto dto) {
		
		return null;
	}

}
