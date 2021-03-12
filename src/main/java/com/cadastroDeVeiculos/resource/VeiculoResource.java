package com.cadastroDeVeiculos.resource;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroDeVeiculos.DTO.VeiculoPayLoadDTO;
import com.cadastroDeVeiculos.services.VeiculoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SuppressWarnings("unused")
@Api(value = "Fornece serviços de emprestimos")
@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

	@Autowired
	private VeiculoService veiculoService;
	
	@ApiOperation(value="inclui veículo")
	@RequestMapping(method = RequestMethod.POST, path = "/incluir")
	public ResponseEntity<?> incluir(@RequestBody VeiculoPayLoadDTO veiculoPayLoadDTO) throws ParseException {
		return new ResponseEntity<>(veiculoService.veiculoIncluir(veiculoPayLoadDTO) , HttpStatus.OK);
	}
	
	@ApiOperation(value="pesquisar veículo")
	@RequestMapping(method = RequestMethod.GET, path = "/pesquisar")
	public ResponseEntity<?> pesquisar(@RequestParam(required = false) String placa, @RequestParam(required = false, defaultValue ="0") Integer numPagina) throws ParseException {
		return new ResponseEntity<>(veiculoService.pesquisarVeiculo(placa, numPagina) , HttpStatus.OK);
	}
	
	
}
