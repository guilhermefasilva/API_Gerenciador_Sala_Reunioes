package io.guilhermefasilva.gerenciador.sala.reuniao.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.guilhermefasilva.gerenciador.sala.reuniao.domain.dto.RoomDtoRequest;
import io.guilhermefasilva.gerenciador.sala.reuniao.domain.dto.RoomDtoResponse;
import io.guilhermefasilva.gerenciador.sala.reuniao.domain.dto.RoomDtoUpdate;
import io.guilhermefasilva.gerenciador.sala.reuniao.domain.model.Room;
import io.guilhermefasilva.gerenciador.sala.reuniao.exception.ResourceNotFoundException;
import io.guilhermefasilva.gerenciador.sala.reuniao.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public RoomDtoResponse create(RoomDtoRequest roomRequest) {
		Room room = modelMapper.map(roomRequest, Room.class);
		this.roomRepository.save(room);
		return modelMapper.map(room, RoomDtoResponse.class);
	}
	
	public List<RoomDtoResponse> findAllRoom(){
		List<Room> room = roomRepository.findAll();
		return room.stream()
				.map(r -> modelMapper.map(r, RoomDtoResponse.class))
				.collect(Collectors.toList());
	}
	
	public RoomDtoResponse findById(Long id) {
		Room room = roomRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Room not found::"+id));
		return modelMapper.map(room, RoomDtoResponse.class);
	}
	
	public RoomDtoResponse update(Long id, RoomDtoUpdate roomUpdate) {
		Room room = roomRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Room not found for this id:: "+ id));
		room.setName(roomUpdate.getName());
		room.setDate(roomUpdate.getDate());
		room.setStartHour(roomUpdate.getStartHour());
		room.setEndHour(roomUpdate.getEndHour());
		this.roomRepository.save(room);
		return modelMapper.map(room, RoomDtoResponse.class);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		Room room = roomRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Room not found for this id:: "+ id));
		this.roomRepository.delete(room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
}
