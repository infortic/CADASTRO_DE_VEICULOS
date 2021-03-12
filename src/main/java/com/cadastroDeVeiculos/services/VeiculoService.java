package com.cadastroDeVeiculos.services;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cadastroDeVeiculos.DTO.PrecoKBBDTO;
import com.cadastroDeVeiculos.DTO.VeiculoPayLoadDTO;
import com.cadastroDeVeiculos.builder.VeiculoBuilder;
import com.cadastroDeVeiculos.entity.VeiculoEntity;
import com.cadastroDeVeiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {

	private static final String url = "https://6048bdf1fb5dcc0017968e3f.mockapi.io/api/v1/kbb/prices/";
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	
	
	
	public VeiculoEntity veiculoIncluir(VeiculoPayLoadDTO veiculoPayLoadDTO) {
		
		VeiculoEntity veiculo = VeiculoBuilder.getinstance()
				.ano(veiculoPayLoadDTO.getAno())
				.dataCadastro(new Date())
				.marca(veiculoPayLoadDTO.getMarca())
				.modelo(veiculoPayLoadDTO.getModelo())
				.placa(veiculoPayLoadDTO.getPlaca())
				.precoAnuncio(veiculoPayLoadDTO.getPrecoAnuncio())
				.precoKbb(this.getPrecoKBB().getPrice())
				.builder();
		
		
		this.getPrecoKBB();
		this.veiculoRepository.save(veiculo);
		return veiculo;
	}
	
	private PrecoKBBDTO getPrecoKBB() {
		Random random = new Random();
		RestTemplate restTemplate = new RestTemplate();
		Integer idPrecoKBB = random.nextInt(6);
		ResponseEntity<String> response = restTemplate.getForEntity(url+idPrecoKBB, String.class);
		return PrecoKBBDTO.getInstace().fromJson(response.getBody());
	}
	
}
