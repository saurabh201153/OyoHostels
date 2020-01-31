package com.oyohostels.oyohostels.service;

import java.util.List;
import java.util.Optional;

import com.oyohostels.oyohostels.domain.Hostel;
import com.oyohostels.oyohostels.domain.Room;
import com.oyohostels.oyohostels.repository.BedRepository;
import com.oyohostels.oyohostels.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyohostels.oyohostels.domain.Bed;

@Service
public class BedService {
	@Autowired
	private BedRepository bedrepository;
	@Autowired
	private RoomService roomService;
	@Autowired
	private HostelService hostelService;

	public void addBed(Bed b,Long hostelid,Long roomid) {
		b.setHostel(hostelService.getHostel(hostelid));
//		b.setRoom(roomService.getRoom(roomid));
		bedrepository.save(b);
	}
	}


