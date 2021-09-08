package io.guilhermefasilva.gerenciador.sala.reuniao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8389367274874268994L;
	
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	

}
