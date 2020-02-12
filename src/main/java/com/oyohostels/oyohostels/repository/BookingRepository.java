package com.oyohostels.oyohostels.repository;

import com.oyohostels.oyohostels.domain.Bed;
import com.oyohostels.oyohostels.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
    List<Booking> findByBedAndEndDateGreaterThanOrderByEndDateAsc(Bed bed, Date start_date);
    List<Booking> findAllByPerson_Id(Long id);
    void deleteById(Long id);
}
