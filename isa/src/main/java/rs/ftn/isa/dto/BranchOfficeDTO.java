package rs.ftn.isa.dto;

import rs.ftn.isa.model.BranchOffice;

public class BranchOfficeDTO {

	private Long id;
	
	private String address;

	public BranchOfficeDTO(Long id, String address) {
		super();
		this.id = id;
		this.address = address;
	}
	
	public BranchOfficeDTO(BranchOffice b) {
		this.id = b.getId();
		this.address = b.getAddress();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
