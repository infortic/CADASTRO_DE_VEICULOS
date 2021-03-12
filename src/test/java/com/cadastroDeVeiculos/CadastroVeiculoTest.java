package com.cadastroDeVeiculos;


import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import com.cadastroDeVeiculos.DTO.VeiculoPayLoadDTO;
import com.cadastroDeVeiculos.services.VeiculoService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CadastroVeiculoTest {

	@Mock
	VeiculoService veiculoService;
	
	@Autowired
	private TestRestTemplate restTemplet;
	@LocalServerPort
	private int port;
	
	@Test
	void contextLoads() {
		VeiculoPayLoadDTO veiculo = new VeiculoPayLoadDTO();
		veiculo.setAno(1990);
		veiculo.setModelo("Hilux");
		
		VeiculoPayLoadDTO veiculoSalvo = this.veiculoService.veiculoIncluir(veiculo);
		
		Assertions.assertThat(veiculoSalvo.getAno()).isEqualTo(1990);
		Assertions.assertThat(veiculoSalvo.getModelo()).isEqualTo(veiculo.getModelo());
	}

	
	

}
