package com.oyohostels.oyohostels.repository;

import com.oyohostels.oyohostels.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Email;

public interface PersonRepository extends CrudRepository<Person,Integer> {

    public Person findById(Long id);
    public Person findByEmail(@Email String email);
}
