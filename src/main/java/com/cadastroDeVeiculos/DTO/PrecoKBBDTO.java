package com.cadastroDeVeiculos.DTO;

import java.math.BigDecimal;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrecoKBBDTO {

	private Long id;
	private BigDecimal price;
			
	public PrecoKBBDTO fromJson(String json) {
		Gson gson = new Gson();
		PrecoKBBDTO precoKBBDTO = gson.fromJson(json , this.getClass());
		return precoKBBDTO;
	}	
	
	public static final PrecoKBBDTO getInstace() {
		return new PrecoKBBDTO();
	}

}