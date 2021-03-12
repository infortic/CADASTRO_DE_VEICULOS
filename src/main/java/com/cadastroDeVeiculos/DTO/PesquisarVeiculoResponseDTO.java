package com.cadastroDeVeiculos.DTO;

import java.math.BigDecimal;
import java.util.Date;

import com.cadastroDeVeiculos.entity.VeiculoEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PesquisarVeiculoResponseDTO {

	private Long id;
	private String placa;
	private BigDecimal precoAnuncio;
	private Integer ano;
	private BigDecimal precoKbb;
	private Date dataCadastro;
	private String modelo;
	private String marca;
	
	public PesquisarVeiculoResponseDTO carregarRetorno(VeiculoEntity veiculoEntity) {
		this.id = veiculoEntity.getId();
		this.placa = veiculoEntity.getPlaca();
		this.precoAnuncio = veiculoEntity.getPrecoAnuncio();
		this.ano = veiculoEntity.getAno();
		this.precoKbb = veiculoEntity.getPrecoKbb();
		this.dataCadastro = veiculoEntity.getDataCadastro();
		this.modelo = veiculoEntity.getModelo();
		this.marca = veiculoEntity.getMarca();
		return this;
	}
	
	public static final PesquisarVeiculoResponseDTO getinstace() {
		return new PesquisarVeiculoResponseDTO();
	}
}
