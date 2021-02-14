package com.contratos.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class MsContratosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsContratosApplication.class, args);
	}
	
  @Bean
   public ModelMapper modelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      return modelMapper;
   }

}
