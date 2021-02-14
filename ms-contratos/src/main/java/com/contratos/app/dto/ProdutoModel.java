package com.contratos.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter 
@Setter 
public class ProdutoModel {

	private Long id;
	private String nome;
	private String descricao;	
	private BigDecimal valor;
	private LocalDate dataCriacao;
	
}
