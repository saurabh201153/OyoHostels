package com.oyohostels.oyohostels.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hostelid;
    private Long roomid;
    private Long roomno;
    private Long bedno;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date beginDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date endDate;
    private String bookingName;
    private String bookingEmail;


    @ManyToOne(targetEntity = Person.class)
    private Person person;
    @ManyToOne(targetEntity = Bed.class)
    private Bed bed;


    public Booking(Long hostelid, Long roomid, Long roomno, Long bedno, Date begin_date, Date endDate, String bookingName,
                   String bookingEmail) {
        super();
        this.hostelid = hostelid;
        this.roomid = roomid;
        this.bedno = bedno;
        this.beginDate = begin_date;
        this.endDate = endDate;
        this.roomno = roomno;
        this.bookingName = bookingName;
        this.bookingEmail = bookingEmail;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHostelid() {
        return hostelid;
    }

    public void setHostelid(Long hostelid) {
        this.hostelid = hostelid;
    }

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public Long getRoomno() {
        return roomno;
    }

    public void setRoomno(Long roomno) {
        this.roomno = roomno;
    }

    public Long getBedno() {
        return bedno;
    }

    public void setBedno(Long bedno) {
        this.bedno = bedno;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail) {
        this.bookingEmail = bookingEmail;
    }

}

