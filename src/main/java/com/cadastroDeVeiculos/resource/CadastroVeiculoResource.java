package com.cadastroDeVeiculos.resource;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroDeVeiculos.DTO.VeiculoPayLoadDTO;
import com.cadastroDeVeiculos.services.VeiculoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SuppressWarnings("unused")
@Api(value = "Fornece serviços de emprestimos")
@RestController
@RequestMapping("/doador")
public class CadastroVeiculoResource {

	@Autowired
	private VeiculoService veiculoService;
	
	@ApiOperation(value="inclui veículo")
	@RequestMapping(method = RequestMethod.POST, path = "/getDoadoresObesos")
	public ResponseEntity<?> incluirVeiculo(@RequestBody VeiculoPayLoadDTO veiculoPayLoadDTO) throws ParseException {
		return new ResponseEntity<>(veiculoService.veiculoIncluir(veiculoPayLoadDTO) , HttpStatus.OK);
	}
	
	
}
