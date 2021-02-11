package com.produtos.app.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter 
@Setter
public class CreateProdutoDto {
	
	private String nome;
	private String descricao;	
	private BigDecimal valor;
}
