package com.oyohostels.oyohostels.service;

import java.util.List;
import java.util.Optional;

import com.oyohostels.oyohostels.domain.Hostel;
import com.oyohostels.oyohostels.repository.BedRepository;
import com.oyohostels.oyohostels.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyohostels.oyohostels.domain.Bed;
import com.oyohostels.oyohostels.domain.Room;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomrepository;
	@Autowired
	private BedRepository bedRepository;
	@Autowired
	private HostelService hostelService;


//	public void addRoom(Room b,Long hostel_id) {
//		b.setHostel(hostelService.getHostel(hostel_id));
//		roomrepository.save(b);
//	}


	public Room getRoom(Long id) {
		return roomrepository.findById(id);
	}


}


