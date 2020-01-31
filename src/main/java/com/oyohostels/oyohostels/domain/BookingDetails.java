package com.oyohostels.oyohostels.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookingDetails {
    private String bookingName;
    private String bookingEmail;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date startDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date endDate;

    public BookingDetails(String bookingName, String bookingEmail,Date startDate, Date endDate) {
        this.bookingName = bookingName;
        this.bookingEmail = bookingEmail;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BookingDetails() {
    }

    public String getBookingName() {
        return bookingName;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
