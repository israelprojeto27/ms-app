package com.contratos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contratos.app.model.ContratoModel;

@Repository
public interface ContratoRepository extends JpaRepository<ContratoModel, Long>{

}
