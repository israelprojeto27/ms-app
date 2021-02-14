package com.contratos.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.contratos.app.dto.ProdutoModel;

@Component
@FeignClient(name = "ms-prod", path="/produto")
public interface ProdutoFeignService {
	
	@GetMapping("/findProdutoById/{idProduto}")
	ResponseEntity<ProdutoModel> getFindProdutoById(@PathVariable String idProduto);

}
