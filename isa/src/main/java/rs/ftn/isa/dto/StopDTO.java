package rs.ftn.isa.dto;

import rs.ftn.isa.model.Stop;

public class StopDTO {

	private Long id;
	
	private String name;

	public StopDTO() {
		super();
	}

	public StopDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public StopDTO(Stop s) {
		this(s.getId(), s.getName());
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
