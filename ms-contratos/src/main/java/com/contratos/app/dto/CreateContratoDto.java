package com.contratos.app.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateContratoDto {

	private String idCliente;
	private String idProduto;
	private long quantidadeItens;
	private String observacao;
	
}
