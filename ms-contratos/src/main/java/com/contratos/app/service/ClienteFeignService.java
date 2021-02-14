package com.contratos.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.contratos.app.dto.ClienteModel;


@Component
@FeignClient(name = "ms-cli",  path="/cliente")
public interface ClienteFeignService {
	
	@GetMapping("/findClienteById/{idCliente}")
	ResponseEntity<ClienteModel> getFindClienteById(@PathVariable String idCliente);

}
