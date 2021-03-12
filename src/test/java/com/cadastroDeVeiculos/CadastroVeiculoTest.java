package com.cadastroDeVeiculos;


import java.math.BigDecimal;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cadastroDeVeiculos.DTO.PesquisarVeiculoResponseDTO;
import com.cadastroDeVeiculos.DTO.VeiculoPayLoadDTO;
import com.cadastroDeVeiculos.services.VeiculoService;
import com.google.common.net.MediaType;

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
	void PesquisarTodosVeiculosMostrarCincoPorPaginaItensDaPaginaUmTEST() {
		Integer numPagina = 0;
		ResponseEntity<?> response = this.restTemplet.getForEntity("/veiculo/pesquisar?numPagina="+numPagina, String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody()).isNotNull();
	}
	
	@Test
	void PesquisarTodosVeiculosMostrarCincoPorPaginaItensDaPaginaDoisTEST() {
		Integer numPagina = 1;
		ResponseEntity<?> response = this.restTemplet.getForEntity("/veiculo/pesquisar?numPagina="+numPagina, String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody()).isNotNull();
	}

	@Test
	void PesquisarVeiculoPorPlacaTest() {
		String placa = "KGB-3111";
		ResponseEntity<?> response = this.restTemplet.getForEntity("/veiculo/pesquisar?placa="+placa, String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody()).isNotNull();
	}
	
	@Test
	void PesquisarPorPlacaTest() {
		VeiculoPayLoadDTO veiculo = new VeiculoPayLoadDTO(); 
		veiculo.setAno(1990);
		veiculo.setMarca("BMW");
		ResponseEntity<?> response = this.restTemplet.postForEntity("/veiculo/incluir",veiculo,PesquisarVeiculoResponseDTO.class,MediaType.JSON_UTF_8);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody()).isNotNull();
	}
}
