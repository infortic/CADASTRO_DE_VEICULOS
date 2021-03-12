package com.cadastroDeVeiculos.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cadastroDeVeiculos.DTO.PesquisarVeiculoResponseDTO;
import com.cadastroDeVeiculos.DTO.PrecoKBBDTO;
import com.cadastroDeVeiculos.DTO.VeiculoPayLoadDTO;
import com.cadastroDeVeiculos.builder.VeiculoBuilder;
import com.cadastroDeVeiculos.entity.VeiculoEntity;
import com.cadastroDeVeiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {

	private static final String URL = "https://6048bdf1fb5dcc0017968e3f.mockapi.io/api/v1/kbb/prices/";
	private static final Integer NUMERO_DE_REGISTROS_POR_PAGINA = 5;
	@Autowired
	private VeiculoRepository veiculoRepository;

	public VeiculoPayLoadDTO veiculoIncluir(VeiculoPayLoadDTO veiculoPayLoadDTO) {

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
		return veiculoPayLoadDTO;
	}

	private PrecoKBBDTO getPrecoKBB() {
		Random random = new Random();
		RestTemplate restTemplate = new RestTemplate();
		Integer idPrecoKBB = random.nextInt(6);
		ResponseEntity<String> response = restTemplate.getForEntity(URL+idPrecoKBB, String.class);
		return PrecoKBBDTO.getInstace().fromJson(response.getBody());
	}
	
	public List<PesquisarVeiculoResponseDTO> pesquisarVeiculo(String placa, Integer numeroPagina) {
		if(placa == null) {
			Pageable pageRequest = PageRequest.of(numeroPagina, NUMERO_DE_REGISTROS_POR_PAGINA);
			Iterable<VeiculoEntity> veiculoList = this.veiculoRepository.findAll(pageRequest);
			return this.carregarResponse(veiculoList);
		}else {
			Iterable<VeiculoEntity> veiculos = this.veiculoRepository.findByPlaca(placa);
			return this.carregarResponse(veiculos);
		}
	}
	
	private List<PesquisarVeiculoResponseDTO> carregarResponse(Iterable<VeiculoEntity> veiculoList) {
		List<PesquisarVeiculoResponseDTO> responseList = new ArrayList<>(); 
		for(VeiculoEntity veiculoInterator : veiculoList) {
			PesquisarVeiculoResponseDTO pesquisarVeiculoResponseDTO = PesquisarVeiculoResponseDTO.getinstace().carregarRetorno(veiculoInterator);
			responseList.add(pesquisarVeiculoResponseDTO);
		}
		return responseList;
	}

}
