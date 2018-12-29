package rs.ftn.isa.dto;

import rs.ftn.isa.model.Destination;

public class DestinationDTO {
	private Long id;
	
	private String name;
	
	public DestinationDTO() {
		super();
	}
	
	public DestinationDTO(Destination d){
		this(d.getId(), d.getName());
	}

	public DestinationDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
