package rs.ftn.isa.dto;

import java.util.ArrayList;
import java.util.List;

import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.model.Room;

public class HotelDTO {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String description;
	
	private String image;
	
	private List<RoomDTO> roomsDTO;

	
	
	public HotelDTO(Long id, String name, String address, String description, String image, List<RoomDTO> roomsDTO) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.image = image;
		this.roomsDTO = roomsDTO;
	}

	public HotelDTO(Hotel hotel) {
		List<RoomDTO> roomsDTO = new ArrayList<>();
		for(Room r : hotel.getRooms()) {
			roomsDTO.add(new RoomDTO(r));
		}
		this.id = hotel.getId();
		this.name = hotel.getName();
		this.address = hotel.getAddress();
		this.description = hotel.getDescription();
		this.image = hotel.getImage();
		this.roomsDTO = roomsDTO;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<RoomDTO> getRoomsDTO() {
		return roomsDTO;
	}

	public void setRoomsDTO(List<RoomDTO> roomsDTO) {
		this.roomsDTO = roomsDTO;
	}
	
	

}
