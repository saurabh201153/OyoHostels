package com.oyohostels.oyohostels.repository;

import com.oyohostels.oyohostels.domain.Bed;
import com.oyohostels.oyohostels.domain.Hostel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BedRepository extends CrudRepository<Bed,Integer> {

    public List<Bed> findAllByHostel_idAndIsOccupied(Long hostel_id,boolean q);

    public List<Bed> findAllByHostel_Id(Long id);

    public List<Bed> findAllByHostel(Hostel hostel);

//    @Query("select b.id from Bed b where b.hostel.id=id")
//    public List<Long> findhostelid(@Param("id") Long id);

    @Query("select distinct b.hostel from Bed b where b.hostel.location=location")
    public List<Hostel> findByHostelLocation(@Param("location") String location);
}

