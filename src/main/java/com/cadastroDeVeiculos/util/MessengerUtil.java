package com.cadastroDeVeiculos.util;

import org.springframework.stereotype.Service;

import com.cadastroDeVeiculos.errors.ResourcesNotFoundException;

@Service
public class MessengerUtil {
	

	public void veryfyObjectIsNull(Object object, String mgs) {
		if (object == null)
			throw new ResourcesNotFoundException(mgs);
	}
	
}
