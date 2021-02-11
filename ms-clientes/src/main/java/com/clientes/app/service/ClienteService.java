package com.clientes.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientes.app.dto.CreateClienteDto;
import com.clientes.app.exceptions.DataNotFoundException;
import com.clientes.app.model.ClienteModel;
import com.clientes.app.repository.ClienteRepository;
import com.clientes.app.utils.Message;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Transactional
	public void createCliente(CreateClienteDto dto) {
		ClienteModel model =  modelMapper.map(dto, ClienteModel.class);
		model.setId(null);
		model.setDataCadastro(LocalDate.now());
		repository.save(model);		
	}


	public List<ClienteModel> findAllClientes() {
		return repository.findAll();
	}


	public ClienteModel findProdutoByIdCliente(String idCliente) {
		return repository.findById(Long.parseLong(idCliente)).orElseThrow(() -> new DataNotFoundException(Message.MSG_ERRO_CLIENTE_NAO_ENCONTRADO));
	}

}
