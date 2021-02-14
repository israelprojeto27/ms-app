package com.contratos.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteModel {
	
	private Long id;	
	private String nome;
	private String cpfCnpj;
	private String email;
	private String descricao;
	private LocalDate dataCadastro;

}
