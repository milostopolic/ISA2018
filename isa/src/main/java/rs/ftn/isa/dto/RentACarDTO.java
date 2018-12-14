package rs.ftn.isa.dto;

import rs.ftn.isa.model.RentACar;

public class RentACarDTO {
	
	private String name;
	
	private String address;
	
	private String description;

	public RentACarDTO(String name, String address, String description) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
	}
	
	public RentACarDTO(RentACar rac) {
		this(rac.getName(), rac.getAddress(), rac.getDescription());
	}

	public RentACarDTO() {
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
