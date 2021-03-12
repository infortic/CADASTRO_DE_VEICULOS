package com.cadastroDeVeiculos.builder;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.cadastroDeVeiculos.entity.VeiculoEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public final class VeiculoBuilder {

	private String placa;
	private BigDecimal precoAnuncio;
	private Integer ano;
	private BigDecimal precoKbb;
	private Date dataCadastro;
	private String modelo;
	private String marca;

	public VeiculoBuilder placa(String placa) {
		this.placa = placa;
		return this;
	}

	public VeiculoBuilder precoAnuncio(BigDecimal precoAnuncio) {
		this.precoAnuncio = precoAnuncio;
		return this;
	}

	public VeiculoBuilder ano(Integer ano) {
		this.ano = ano;
		return this;
	}

	public VeiculoBuilder precoKbb(BigDecimal precoKbb) {
		this.precoKbb = precoKbb;
		return this;
	}

	public VeiculoBuilder dataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
		return this;
	}

	public VeiculoBuilder marca(String marca) {
		this.marca = marca;
		return this;
	}
	
	public VeiculoBuilder modelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public  VeiculoEntity builder() {
		return new VeiculoEntity(placa, precoAnuncio, ano, precoKbb, dataCadastro , modelo, marca);
	}
	
	public static final	VeiculoBuilder getinstance() {
		return new VeiculoBuilder();
	}
	
}
