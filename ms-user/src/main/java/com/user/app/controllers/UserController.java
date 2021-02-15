package com.user.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.dto.CreateUserDto;
import com.user.app.dto.Response;
import com.user.app.model.UserModel;
import com.user.app.repository.UserRepository;
import com.user.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/listAll")
	public ResponseEntity<?> listAllUsers() {
		return new ResponseEntity<>(service.listAllClientes(), HttpStatus.OK);
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<UserModel> findByEmail(@RequestParam String email) {
		return new ResponseEntity<UserModel>(service.findUserByEmail(email), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto dto) {
		try {
			service.createProduto(dto);
			Response response = new Response(null, "sucesso", HttpStatus.CREATED, "Usuario criado com sucessso", null);		
			return new ResponseEntity<>(response, response.getStatus());
		}
		catch(Exception e) {
			Response response = new Response(null, "erro", HttpStatus.BAD_REQUEST, "Erro generico", null);
			return new ResponseEntity<>(response, response.getStatus());
		}
	}
}
