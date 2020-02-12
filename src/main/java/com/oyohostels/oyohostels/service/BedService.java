package com.oyohostels.oyohostels.service;

import com.oyohostels.oyohostels.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyohostels.oyohostels.domain.Bed;

@Service
public class BedService {
	@Autowired
	private BedRepository bedrepository;
	@Autowired
	private HostelService hostelService;

	public void addBed(Bed b,Long hostelid) {
		b.setHostel(hostelService.getHostel(hostelid));
//		b.setRoom(roomService.getRoom(roomid));
		bedrepository.save(b);
	}
	}


