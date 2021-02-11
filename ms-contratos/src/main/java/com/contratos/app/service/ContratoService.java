package com.contratos.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contratos.app.dto.CreateContratoDto;
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

	@Transactional
	public void createContrato(CreateContratoDto dto) {
		ContratoModel model = modelMapper.map(dto, ContratoModel.class);
		model.setId(null);
		model.setDataCriacao(LocalDate.now());
		repository.save(model);
	}

	public List<ContratoModel> findAllContratos() {
		return repository.findAll();
	}

	public List<ContratoModel>  findAllContratosByIdCliente(String idCliente) {
		return null;
	}

	public ContratoModel findContratoByIdContrato(String idContrato) {
		return repository.findById(Long.parseLong(idContrato)).orElseThrow(() -> new DataNotFoundException(Message.MSG_ERRO_CONTRATO_NAO_ENCONTRADO));
	}

}
