package com.contratos.app.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contratos.app.dto.ClienteModel;
import com.contratos.app.dto.CreateContratoDto;
import com.contratos.app.dto.ProdutoModel;
import com.contratos.app.exceptions.DataNotFoundException;
import com.contratos.app.model.ContratoModel;
import com.contratos.app.repository.ContratoRepository;
import com.contratos.app.utils.Message;



@Service
public class ContratoService {
	
	@Autowired
	private ContratoRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClienteFeignService clienteFeignService;
	
	@Autowired
	private ProdutoFeignService produtoFeignService;

	@Transactional
	public void createContrato(CreateContratoDto dto) {
		ContratoModel model = new ContratoModel();
		
		ClienteModel clienteModel = clienteFeignService.getFindClienteById(dto.getIdCliente()).getBody();		
		ProdutoModel produtoModel = produtoFeignService.getFindProdutoById(dto.getIdProduto()).getBody();
		
		model.setIdCliente(clienteModel.getId());
		model.setNomeCliente(clienteModel.getNome());
		
		model.setIdProduto(produtoModel.getId());
		model.setNomeProduto(produtoModel.getNome());
		
		model.setQuantidadeItens(dto.getQuantidadeItens());
		model.setValorTotal(produtoModel.getValor().multiply( BigDecimal.valueOf(model.getQuantidadeItens()) ));		
		
		model.setId(null);
		model.setDataCriacao(LocalDate.now());
		repository.save(model);
	}

	public List<ContratoModel> findAllContratos() {
		ClienteModel clienteModel = clienteFeignService.getFindClienteById("1").getBody();
		System.out.println("Cliente recuperado: " + clienteModel.getNome());
		return repository.findAll();
	}

	public List<ContratoModel>  findAllContratosByIdCliente(String idCliente) {
		return null;
	}

	public ContratoModel findContratoByIdContrato(String idContrato) {
		return repository.findById(Long.parseLong(idContrato)).orElseThrow(() -> new DataNotFoundException(Message.MSG_ERRO_CONTRATO_NAO_ENCONTRADO));
	}

}
