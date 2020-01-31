package com.oyohostels.oyohostels.repository;
import java.util.List;

import com.oyohostels.oyohostels.domain.Hostel;
import org.apache.catalina.Host;
import org.springframework.data.repository.CrudRepository;

public interface HostelRepository extends CrudRepository<Hostel,Integer> {

	public List<Hostel> findAllByLocation(String location);
	public Hostel findById(Long id);
}

