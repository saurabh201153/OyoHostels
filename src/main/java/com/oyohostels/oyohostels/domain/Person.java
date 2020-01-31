package com.oyohostels.oyohostels.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    @Email
    private String email;
    private Long phone;
    private String password;


    public Person(Long id, String name, @Email String email, Long phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPasswordd() {
        return password;
    }

    public void setPassword(String passwd) {
        this.password = passwd;
    }

}
