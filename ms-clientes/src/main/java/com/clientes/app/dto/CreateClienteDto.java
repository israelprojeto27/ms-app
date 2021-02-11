package com.clientes.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClienteDto {

	private String nome;
	private String cpfCnpj;
	private String email;
	private String descricao;
	
}
