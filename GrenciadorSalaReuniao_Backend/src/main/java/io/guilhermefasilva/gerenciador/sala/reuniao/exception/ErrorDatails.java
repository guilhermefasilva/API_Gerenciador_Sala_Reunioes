package io.guilhermefasilva.gerenciador.sala.reuniao.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDatails {
	
	private Date timestamp;
	private String message;
	private String datails;

}
