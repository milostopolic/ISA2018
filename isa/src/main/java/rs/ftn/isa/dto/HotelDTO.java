package rs.ftn.isa.dto;

import rs.ftn.isa.model.Hotel;

public class HotelDTO {
	
	private String name;
	
	private String address;
	
	private String description;

	public HotelDTO(String name, String address, String description) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
	}
	
	public HotelDTO(Hotel hotel) {
		this(hotel.getName(), hotel.getAddress(), hotel.getDesciption());
	}

	public HotelDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
