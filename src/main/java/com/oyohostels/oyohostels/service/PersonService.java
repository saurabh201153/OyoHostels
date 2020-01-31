package com.oyohostels.oyohostels.service;

import com.oyohostels.oyohostels.domain.Login;
import com.oyohostels.oyohostels.domain.Person;
import com.oyohostels.oyohostels.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void add(Person person){
        personRepository.save(person);
    }

    public Person getPerson(Long id){
        return personRepository.findById(id);
    }

    public Person getByEmail(@Email String email){
        return personRepository.findByEmail(email);
    }

    public void updatedetails(Person person){
        personRepository.save(person);
    }

    public Map<Long,String> Login(Login login){

        Map<Long,String> data = new HashMap<>();
        Person person = personRepository.findByEmail(login.getEmail());
        if(person!= null){
            if(person.getPasswordd().equals(login.getPassword())){
                data.put(person.getId(),"");
                return data;
            }
            else{
                data.put(person.getId(),"WrongPassword");
                return data;
            }
        }
        data.put(Long.valueOf(-1),"Username does not exist");
        return data;
    }
}
