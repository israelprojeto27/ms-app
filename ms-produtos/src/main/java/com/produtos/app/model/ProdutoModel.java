package com.produtos.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@NoArgsConstructor 
@AllArgsConstructor
@Getter 
@Setter 
public class ProdutoModel {
	
	public ProdutoModel(String nome, String descricao, BigDecimal valor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;	
	private BigDecimal valor;
	private LocalDate dataCriacao;
	
	
}
