package io.guilhermefasilva.gerenciador.sala.reuniao.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RoomDtoResponse {
	
	@ApiModelProperty(value = "Exibe id de uma sala de reuniões",example =  "1")
	private Long id;
	@ApiModelProperty(value = "Exibe nome de uma sala de reuniões",example =  "Sala Azul")
	private String name;
	@ApiModelProperty(value = "Exibe data de reserva de uma sala de reuniões",example =  "07/09/2021")
	private String date;
	@ApiModelProperty(value = "Exibe hora inicial de uma reserva da sala de reuniões",example =  "19:00")
	private String startHour;
	@ApiModelProperty(value = "Exibe hora final de uma reserva da sala de reuniões",example =  "22:00")
	private String endHour;

}
