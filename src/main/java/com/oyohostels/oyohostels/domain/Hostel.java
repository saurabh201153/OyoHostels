package com.oyohostels.oyohostels.domain;


import java.util.List;

import javax.persistence.*;

@Entity
public class Hostel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String location;
	private String name;
	private String description;
	private int price;
	private String address;
	private String availability;
	private String image;
//	@OneToMany(targetEntity=Bed.class)
//	private List<Bed> beds;

	public Hostel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Hostel(Long id, String location, String name, String description, int price, String address,
			String availability, String image) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.description = description;
		this.price = price;
		this.address = address;
		this.availability = availability;
		this.image = image;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
//	public List<Bed> getBeds() {
//		return beds;
//	}
//
//	public void setBeds(List<Bed> beds) {
//		this.beds = beds;
//	}
}
