package com.oyohostels.oyohostels.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Bed")
public class Bed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long bedno;
	private Boolean isOccupied;
//	@ManyToOne(targetEntity = Room.class)
//	private Room room;
	@ManyToOne(targetEntity = Hostel.class)
	private Hostel hostel;
//	@OneToMany(targetEntity = Booking.class)
//	private List<Booking> book;

	public Bed() {
		this.isOccupied=false;
	}

	public Boolean getIsOccupied() {
		return isOccupied;
	}
	public void setIsOccupied(Boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getOccupied() {
		return isOccupied;
	}

	public void setOccupied(Boolean occupied) {
		isOccupied = occupied;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

//	public Room getRoom() {
//		return room;
//	}
//
//	public void setRoom(Room room) {
//		this.room = room;
//	}

	public Long getBedno() {
		return bedno;
	}

	public void setBedno(Long bedno) {
		this.bedno = bedno;
	}

//	public List<Booking> getBook() {
//		return book;
//	}
//
//	public void setBook(List<Booking> book) {
//		this.book = book;
//	}
}
