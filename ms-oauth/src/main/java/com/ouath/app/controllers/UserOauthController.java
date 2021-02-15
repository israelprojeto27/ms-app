package com.ouath.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ouath.app.dto.Response;
import com.ouath.app.dto.UserModel;
import com.ouath.app.service.UserService;


@RestController
@RequestMapping("/userOauth")
public class UserOauthController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/findByEmail")
	public ResponseEntity<?> findByEmail(@RequestParam String email) {
		try {
			return new ResponseEntity<UserModel>(service.findUserByEmail(email), HttpStatus.OK);	
		}
		catch(IllegalArgumentException e) {
		    Response response = new Response(null, "erro", HttpStatus.NOT_FOUND, "Erro generico", null);
			return new ResponseEntity<>(response, response.getStatus());	
		}
		
	}
	

}
