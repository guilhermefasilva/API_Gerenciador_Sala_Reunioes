package io.guilhermefasilva.gerenciador.sala.reuniao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.guilhermefasilva.gerenciador.sala.reuniao.domain.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
