package com.cadastroDeVeiculos.repository;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.cadastroDeVeiculos.entity.VeiculoEntity;

public interface VeiculoRepository extends PagingAndSortingRepository<VeiculoEntity, Long>{
	 public List<VeiculoEntity> findByPlaca(String placa);	
}
