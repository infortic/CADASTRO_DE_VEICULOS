package com.cadastroDeVeiculos.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.cadastroDeVeiculos.entity.VeiculoEntity;

public interface VeiculoRepository extends PagingAndSortingRepository<VeiculoEntity, Long>{

	
	
}