package com.oyohostels.oyohostels.domain;


import java.util.List;

import javax.persistence.*;

@Entity(name = "Room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long roomno;
	private int availabale_beds;
	private Boolean isFull;

//	@ManyToOne(targetEntity = Hostel.class)
//	private Hostel hostel;


	public Room() {
		super();
		isFull=false;
	}
	
	public Boolean getIsFull() {
		return isFull;
	}
	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}
	public int getAvailabale_beds() {
		return availabale_beds;
	}
	public void setAvailabale_beds(int availabale_beds) {
		this.availabale_beds = availabale_beds;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public Hostel getHostel() {
//		return hostel;
//	}
//	public void setHostel(Hostel hostel) {
//		this.hostel = hostel;
//	}
	public Long getRoomno() {
		return roomno;
	}
	public void setRoomno(Long roomno) {
		this.roomno = roomno;
	}
}
