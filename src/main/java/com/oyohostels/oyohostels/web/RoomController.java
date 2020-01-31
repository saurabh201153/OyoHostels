package com.oyohostels.oyohostels.web;

import java.time.LocalDate;
import java.util.List;

import com.oyohostels.oyohostels.domain.Bed;
import com.oyohostels.oyohostels.domain.Hostel;
import com.oyohostels.oyohostels.domain.Room;
import com.oyohostels.oyohostels.service.BedService;
import com.oyohostels.oyohostels.service.HostelService;
import com.oyohostels.oyohostels.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("oyohostels")
@RestController
public class RoomController {
	@Autowired
	private RoomService roomservice;

//	@PostMapping("addroom/{hostel_id}")
//	public void addRoom(@RequestBody Room b, @PathVariable Long hostel_id){
//		roomservice.addRoom(b,hostel_id);
//	}
//
	
}
