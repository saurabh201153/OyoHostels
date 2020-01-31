package com.oyohostels.oyohostels.service;

import java.util.*;

import com.oyohostels.oyohostels.Utils.BookingUtils;
import com.oyohostels.oyohostels.domain.Bed;
import com.oyohostels.oyohostels.domain.Booking;
import com.oyohostels.oyohostels.domain.Hostel;
import com.oyohostels.oyohostels.repository.BedRepository;
import com.oyohostels.oyohostels.repository.HostelRepository;
import com.oyohostels.oyohostels.repository.RoomRepository;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyohostels.oyohostels.domain.Room;

@Service
public class HostelService {
	@Autowired
	private HostelRepository hostelrepository;
	@Autowired
	private BedRepository bedRepository;
	@Autowired
	private BookingService bookingService;
//
//	public List<Hostel> getAllHostel(String location) {
//		List<Hostel> h= new ArrayList<>();
//		hostelrepository.findByLocation(location).forEach(h::add);
//		return h;
//	}

	public Hostel getHostel(Long id) {
		Hostel h = hostelrepository.findById(id);
		if (h != null)
			return h;
		else return null;
	}

	public List<Hostel> getHostelByLocationAndDate(String location, Date start_date, Date end_date) {
		List<Hostel> hostel = hostelrepository.findAllByLocation(location);
		List<Hostel> hostels = new ArrayList<>();
//		boolean f;
//		for(Hostel h:hostel){
//			Map< Bed, List<Booking> > bookingsForBed = new HashMap<>();
//			f=false;
//			List<Bed> bedList = bedRepository.findAllByHostel(h);
//			for(Bed bed:bedList){
//				List<Booking> futureBookingsForBed = bookingService.checkIsBedHasActiveBookings(bed,start_date);
//				if(futureBookingsForBed.isEmpty()){
//					f=true;
//					hostels.add(h);
//					System.out.println(h.getName()+"1");
//					break;
//				}
//				bookingsForBed.put(bed,futureBookingsForBed);
//			}
//			if(f)continue;
//			for(Map.Entry<Bed,List<Booking>> entry : bookingsForBed.entrySet()){
//				if(BookingUtils.isBookingAvilable(entry.getValue(),start_date,end_date)){
//					hostels.add(h);
//					System.out.println(h.getName()+"2");
//					break;
//				}
//			}
//		}

		for (Hostel h : hostel) {
			Bed bed = bookingService.getBedForBooking(h.getId(), start_date, end_date);
			if (bed == null)continue;
				hostels.add(h);
		}
		return hostels;
	}

	public void addHostel(Hostel hostel) {
		hostelrepository.save(hostel);
	}

}


