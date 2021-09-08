package io.guilhermefasilva.gerenciador.sala.reuniao.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.guilhermefasilva.gerenciador.sala.reuniao.domain.dto.RoomDtoRequest;
import io.guilhermefasilva.gerenciador.sala.reuniao.domain.dto.RoomDtoResponse;
import io.guilhermefasilva.gerenciador.sala.reuniao.domain.dto.RoomDtoUpdate;
import io.guilhermefasilva.gerenciador.sala.reuniao.service.RoomService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
		
		
		@Autowired
		private RoomService roomService;
		
		@PostMapping
		@ApiOperation(value = "Realiza o cadastro de salas de reuniões")
		@ApiResponses(value = {
							@ApiResponse(code = 201, message = "Requisição bem sucedida"),
							@ApiResponse(code = 400, message = "Requisição não atendida dados incorretos ou falta informações"),
							@ApiResponse(code = 500, message = "Sistema indisponivel")})
		public ResponseEntity<RoomDtoResponse> createRoom(@Valid @RequestBody RoomDtoRequest roomRequest) {
			RoomDtoResponse roomResponse = roomService.create(roomRequest);
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path("{id}")
					.buildAndExpand(roomResponse.getId())
					.toUri();
			return ResponseEntity.created(uri).body(roomResponse);
		}
		
		@GetMapping
		@ApiOperation(value = "Realiza exibição de todas as salas de reuniões cadastradas")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Requisição bem sucedida"),
				@ApiResponse(code = 500, message = "Sistema indisponivel")})
		public ResponseEntity<List<RoomDtoResponse>> getAllRoom(){
			List<RoomDtoResponse> roomResponse = roomService.findAllRoom();
			return ResponseEntity.ok(roomResponse);
		}
		
		
		@GetMapping("/{id}")
		@ApiOperation(value = "Exibe uma sala de reunião através de um Id válido informado na URL")
		@ApiResponses(value= {
					@ApiResponse(code = 200, message = "Requisição bem sucedida"),
					@ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta informações"),
					@ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado")})
		public ResponseEntity<RoomDtoResponse> getByIdRoom(@Valid @PathVariable Long id){
			RoomDtoResponse roomResponse = roomService.findById(id);
			return ResponseEntity.ok(roomResponse);
		}	
		
	
		@PutMapping("/{id}")
		@ApiOperation(value = "Atualizar dados de uma sala de reunião")
		@ApiResponses(value = {
						@ApiResponse(code = 200, message = "Requisição bem sucedida" ),
						@ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta informações"),
						@ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado"),
						@ApiResponse(code = 500, message = "Sistema indisponivel")})
		public ResponseEntity<RoomDtoResponse> updateRoom(@Valid @PathVariable Long id, @Valid @RequestBody RoomDtoUpdate roomUpdate){
			RoomDtoResponse roomResponse = roomService.update(id, roomUpdate);
			return ResponseEntity.ok(roomResponse);
		}
		
		@DeleteMapping("/{id}")
		@ApiOperation(value = "Excluir uma sala de reuniões da base de dados.")
		@ApiResponses(value= {
							@ApiResponse(code = 200, message = "Requisição bem sucedida"),
							@ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado"),
							@ApiResponse(code = 500, message = "Sistema indisponivel")})
		public Map<?,?> deleteRoom(@Valid @PathVariable Long id){
			return this.roomService.delete(id);
			
			
		}
		
}
