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
    private String hostelname;
    private Long price;

    @ManyToOne(targetEntity = Person.class)
    private Person person;
    @ManyToOne(targetEntity = Bed.class)
    private Bed bed;

    String newline = System.getProperty("line.separator");

    public Booking(Long hostelid, Long roomid, Long roomno, Long bedno, Date begin_date, Date endDate, String bookingName,
                   String bookingEmail, Long price) {
        super();
        this.hostelid = hostelid;
        this.roomid = roomid;
        this.bedno = bedno;
        this.beginDate = begin_date;
        this.endDate = endDate;
        this.roomno = roomno;
        this.bookingName = bookingName;
        this.bookingEmail = bookingEmail;
        this.price=price;
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

    public String getHostelname() {
        return hostelname;
    }

    public void setHostelname(String hostelname) {
        this.hostelname = hostelname;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ("<html>" +
                "<div style=\"border: solid; border-color: black; border-width: 3px; border-radius: 5px; margin-left: 10px;\">" +
		"<header style= \"background-color:tomato; font-size: 50px; width: auto; text-align: center;margin-bottom: 10px\">"+"#" + id + "Confirmed!!!</header>" +
		"<div style=\"font-size: 30px; margin-left: 10px\"> " +
			"<div><b>Name: </b>" + bookingName + "</div>" +
			"<div><b>Email: </b>" + bookingEmail + "</div>" +
			"<div><b>Hostel Name: </b>" + hostelname + " -"  + hostelid + "</div>" +
			"<div><b>Room No. : </b>" + roomno + "</div>" +
			"<div><b>Bed No.: </b>" + bedno + "</div>" +
			"<div><b>CheckIn: </b>" + beginDate.toString().substring(0,10)+beginDate.toString().substring(23,28) + "</div>" +
			"<div><b>CheckOut: </b>" + endDate.toString().substring(0,10) +beginDate.toString().substring(23,28) + "</div>" +
			"<div><b>Total Price: </b>" + price + "</div>" +
		"</div>" +
		"<div style= \"padding-left: 10px\"><p>The Total amount shown here is the amount you pay at the property.<br>" +
               " OyoHostels does not charge any reservation, administration and other charges</p>" +
		"</div>" +
	"</div>" + "</html>"
        );
    }
}

