package com.oyohostels.oyohostels.web;

import com.oyohostels.oyohostels.Exception.NoAvailableRoomsException;
import com.oyohostels.oyohostels.domain.Booking;
import com.oyohostels.oyohostels.domain.BookingDetails;
import com.oyohostels.oyohostels.repository.BedRepository;
import com.oyohostels.oyohostels.service.BookingService;
import com.oyohostels.oyohostels.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@RequestMapping("oyohostels/booking")
@RestController
@CrossOrigin("http://localhost:3000")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{user_id}/{hostel_id}")
    public String add(@PathVariable Long user_id, @PathVariable Long hostel_id, @RequestBody BookingDetails bookingDetails) {
          return bookingService.addBooking1(user_id,hostel_id,bookingDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        bookingService.delete(id);
    }

//    @PutMapping("/{user_id}/{hostel_id}/finalsubmit")
//    public void update(@RequestBody Booking book){
//        bookingService.update(book);
//    }

}
