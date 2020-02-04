package com.oyohostels.oyohostels.web;

import java.util.List;

import com.oyohostels.oyohostels.domain.Bed;
import com.oyohostels.oyohostels.domain.Hostel;
import com.oyohostels.oyohostels.domain.Room;
import com.oyohostels.oyohostels.repository.BedRepository;
import com.oyohostels.oyohostels.service.BedService;
import com.oyohostels.oyohostels.service.HostelService;
import com.oyohostels.oyohostels.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("oyohostels")
@RestController
public class BedController {
	@Autowired
	private BedService bedservice;
	@Autowired
	private BedRepository bedRepository;
	@Autowired
	private HostelService hostelService;
	

	@PostMapping("addbed/{hostel_id}")
	public void addBed(@RequestBody Bed b, @PathVariable Long hostel_id){
		bedservice.addBed(b,hostel_id);
	}
	@GetMapping("findbed/{hostel_id}")
	public List<Bed> find(@PathVariable Long hostel_id){
		return bedRepository.findAllByHostel_Id(hostel_id);
	}
	
	
}
