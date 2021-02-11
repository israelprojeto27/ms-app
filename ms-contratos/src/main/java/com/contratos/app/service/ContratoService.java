package com.contratos.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contratos.app.repository.ContratoRepository;

@Service
public class ContratoService {
	
	@Autowired
	private ContratoRepository repository;

}
