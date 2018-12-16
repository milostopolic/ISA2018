package rs.ftn.isa.dto;

import rs.ftn.isa.model.Room;

public class RoomDTO {
	
	private Long id;
	
	private int beds;
	
	private float price;

	public RoomDTO(Long id, int beds, float price) {
		super();
		this.id = id;
		this.beds = beds;
		this.price = price;
	}
	
	public RoomDTO(Room r) {
		this(r.getId(), r.getBeds(), r.getPrice());
	}

	public RoomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	 

}
