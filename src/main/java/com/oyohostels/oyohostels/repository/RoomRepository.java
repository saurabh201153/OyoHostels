package com.oyohostels.oyohostels.repository;

import com.oyohostels.oyohostels.domain.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Integer> {
      public Room findById(Long id);
}

