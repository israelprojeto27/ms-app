package com.user.app.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
@Getter 
@Setter 
public class CreateUserDto {
	
	private String nome;
	private String email;
	private String password;
	private String rolename;
}
