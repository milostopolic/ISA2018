package rs.ftn.isa.dto;

import rs.ftn.isa.model.Airline;

public class AirlineDTO {
	
	private String name;
	
	private String address;
	
	private String description;

	public AirlineDTO(String name, String address, String description) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
	}
	
	public AirlineDTO(Airline airline) {
		this(airline.getName(), airline.getAddress(), airline.getDescription());
	}

	public AirlineDTO() {
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
