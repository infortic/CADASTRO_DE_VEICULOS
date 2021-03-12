package com.cadastroDeVeiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigurationPackage
public class CadastroVeiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroVeiculoApplication.class, args);	
	}

}