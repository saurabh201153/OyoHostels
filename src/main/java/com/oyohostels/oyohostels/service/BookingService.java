package com.oyohostels.oyohostels.service;

import com.oyohostels.oyohostels.Exception.NoAvailableRoomsException;
import com.oyohostels.oyohostels.domain.Bed;
import com.oyohostels.oyohostels.domain.Booking;
import com.oyohostels.oyohostels.domain.BookingDetails;
import com.oyohostels.oyohostels.repository.BedRepository;
import com.oyohostels.oyohostels.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oyohostels.oyohostels.Utils.*;

import java.util.*;

@Service
public class BookingService {

    @Autowired
    private HostelService hostelService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BedRepository bedRepository;
    @Autowired
    private PersonService personService;


    public String addBooking1(Long user_id, Long hostel_id,BookingDetails bookingDetails){
        Booking book = new Booking();
        Bed bed = getBedForBooking(hostel_id,bookingDetails.getStartDate(),bookingDetails.getEndDate());
        if(bed==null)return "NO rooms Available";
        book.setBed(bed);
//        book.setRoomid(bed.getRoom().getId());
        book.setHostelid(bed.getHostel().getId());
        book.setBedno(bed.getBedno());
        book.setRoomno(bed.getRoomno());
        book.setPerson(personService.getPerson(user_id));
        book.setHostelname(bed.getHostel().getName());
        book.setBeginDate(bookingDetails.getStartDate());
        book.setEndDate(bookingDetails.getEndDate());
        book.setBookingName(bookingDetails.getBookingName());
        book.setBookingEmail(bookingDetails.getBookingEmail());
        book.setPrice((long) bed.getHostel().getPrice());
        bookingRepository.save(book);
        EmailService.EmailService(book);
        return "OK" ;
    }

    public Bed getBedForBooking(Long hostel_id, Date start_date,Date end_date)  {
        List<Bed> bedList = bedRepository.findAllByHostel_Id(hostel_id);
//        List<Bed> bedList = hostelService.getHostel(hostel_id).getBeds();
        Map< Bed, List<Booking> > bookingsForBed = new HashMap<>();
        for(Bed bed:bedList){
            List<Booking> futureBookingsForBed = checkIsBedHasActiveBookings(bed,start_date);
            if(futureBookingsForBed.isEmpty())return bed;
            bookingsForBed.put(bed,futureBookingsForBed);
        }
        for(Map.Entry<Bed,List<Booking>> entry : bookingsForBed.entrySet()){
            if(BookingUtils.isBookingAvilable(entry.getValue(),start_date,end_date))
                return entry.getKey();
        }
        return null;
    }

    public List<Booking> checkIsBedHasActiveBookings(Bed bed, Date startDate) {
        return bookingRepository.findByBedAndEndDateGreaterThanOrderByEndDateAsc(bed, startDate);
    }


    public List<Booking> bookingPersonId(Long id){
        return bookingRepository.findAllByPerson_Id(id);
    }


    public void delete(Long id){
        bookingRepository.deleteById(Math.toIntExact(id));
    }

}
