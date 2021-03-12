package com.cadastroDeVeiculos.DTO;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class VeiculoPayLoadDTO {
	
	private String placa;
	@JsonAlias("preco_anuncio")
	private BigDecimal precoAnuncio;
	private Integer ano;
	private String modelo;
	private String marca;
	
}
