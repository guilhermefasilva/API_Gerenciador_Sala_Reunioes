package io.guilhermefasilva.gerenciador.sala.reuniao.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String name;
		private String date;
		private String startHour;
		private String endHour;
}
