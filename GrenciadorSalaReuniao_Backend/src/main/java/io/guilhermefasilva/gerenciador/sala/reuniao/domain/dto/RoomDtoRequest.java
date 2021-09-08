package io.guilhermefasilva.gerenciador.sala.reuniao.domain.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDtoRequest {
	
	@ApiModelProperty(value = "Nome da sala de reuniões não pode ficar em branco",example =  "Sala Verde",required = true)
	@NotBlank(message = "Não pode estar em branco")
	private String name;
	
	@ApiModelProperty(value = "Campo data não pode ficar em branco",example =  "07/09/2021",required = true)
	@NotBlank(message = "Não pode estar em branco")
	private String date;
	
	@ApiModelProperty(value = "Campo startHour não pode ficar em branco",example =  "21:00",required = true)
	@NotBlank(message = "Não pode estar em branco")
	private String startHour;
	
	@ApiModelProperty(value = "Campo endtHour não pode ficar em branco",example =  "22:00",required = true)
	@NotBlank(message = "Não pode estar em branco")
	private String endHour;
}
