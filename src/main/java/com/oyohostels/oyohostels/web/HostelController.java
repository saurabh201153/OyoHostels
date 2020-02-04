package com.oyohostels.oyohostels.web;

import java.util.Date;
import java.util.List;

import com.oyohostels.oyohostels.domain.Bed;
import com.oyohostels.oyohostels.domain.Hostel;
import com.oyohostels.oyohostels.repository.BedRepository;
import com.oyohostels.oyohostels.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


@RequestMapping("oyohostels/")
@RestController
@CrossOrigin("http://localhost:3000")
public class HostelController {
	@Autowired
	private HostelService hostelservice;
	
	@GetMapping("/{location}/{start_date}/{end_date}")
	public List<Hostel> getAllHostel(@PathVariable String location, @PathVariable("start_date") @DateTimeFormat(pattern="dd-MM-yyyy") Date start_date,
									 @PathVariable("end_date") @DateTimeFormat(pattern="dd-MM-yyyy") Date end_date){
		return hostelservice.getHostelByLocationAndDate(location,start_date,end_date);}

	@GetMapping("/{location}/{id}")
	public Hostel getHostel(@PathVariable Long id)
	{
		return hostelservice.getHostel(id);
	}

	@PostMapping("/addhostel")
	public void addHostel(@RequestBody Hostel hostel){
		hostelservice.addHostel(hostel);
	}

//	@GetMapping("/getbeds/{hostel_id}")
//	public List<Bed> getbeds(@PathVariable Long hostel_id){
//		return hostelservice.getHostel(hostel_id).getBeds();
//	}
	
}
