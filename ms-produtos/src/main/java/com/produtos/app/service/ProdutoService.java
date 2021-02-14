package com.produtos.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.app.dto.CreateProdutoDto;
import com.produtos.app.exceptions.DataNotFoundException;
import com.produtos.app.model.ProdutoModel;
import com.produtos.app.repository.ProdutoRepository;
import com.produtos.app.utils.Message;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public void createProduto(@Valid CreateProdutoDto dto) {
		ProdutoModel model = modelMapper.map(dto, ProdutoModel.class);
		model.setId(null);
		model.setDataCriacao(LocalDate.now());
		repository.save(model);
		
	}

	public List<ProdutoModel> findAllProdutos() {
		return repository.findAll();
	}

	public ProdutoModel findProdutoByIdProduto(String idProduto) {		
		return repository.findById(Long.parseLong(idProduto)).orElseThrow(() -> new DataNotFoundException(Message.MSG_ERRO_PRODUTO_NAO_ENCONTRADO));		
	}

	public List<ProdutoModel> findProdutoByNomeProduto(String nomeProduto) {
		return repository.findByNomeContaining(nomeProduto);
	}



}
