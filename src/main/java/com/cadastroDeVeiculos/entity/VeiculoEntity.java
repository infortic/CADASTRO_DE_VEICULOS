package com.cadastroDeVeiculos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class VeiculoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String placa;
	private BigDecimal precoAnuncio;
	private Integer ano;
	private BigDecimal precoKbb;
	private Date dataCadastro;
	private String modelo;
	private String marca;
	
}
