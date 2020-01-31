package com.oyohostels.oyohostels.web;

import com.oyohostels.oyohostels.domain.Booking;
import com.oyohostels.oyohostels.domain.Login;
import com.oyohostels.oyohostels.domain.Person;
import com.oyohostels.oyohostels.service.BookingService;
import com.oyohostels.oyohostels.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("oyohostels/profile")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private BookingService bookingService;


    @PostMapping("/signup")
    public void add(@RequestBody Person person){
        personService.add(person);
    }

    @GetMapping("/{user_id}")
    public Person getAllDetails(@PathVariable Long user_id){
        return personService.getPerson(user_id);
    }

    @PostMapping("/login")
    public Map<Long,String> Login(@RequestBody Login login){
        return personService.Login(login);
    }

    @GetMapping("{user_id}/booking")
    public List<Booking> getBookings(@PathVariable Long user_id){
        return bookingService.bookingPersonId(user_id);
    }
}
