package rs.ftn.isa.dto;

import java.util.ArrayList;
import java.util.List;

import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.Flight;

public class AirlineDTO {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String description;
	
	private List<String> destinations;
	
	private List<FlightDTO> flightsDTO;	
	
	private String image;
	
	public AirlineDTO(Long id, String name, String address, String description, List<String> destinations,
			List<FlightDTO> flightsDTO, String image) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.destinations = destinations;
		this.flightsDTO = flightsDTO;
		this.image = image;
	}

	public AirlineDTO(Airline airline) {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		List<String> destinations = new ArrayList<>();
		for(String d : airline.getDestinations()) {
			destinations.add(d);
		}
		System.out.println("prvi");
		for(Flight f : airline.getFlights()) {
			flightsDTO.add(new FlightDTO(f));
		}
		System.out.println("drugi");
		this.id = airline.getId();
		this.name = airline.getName();
		this.address = airline.getAddress();
		this.description = airline.getDescription();
		this.destinations = airline.getDestinations();
		this.flightsDTO = flightsDTO;
		this.image = airline.getImage();
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}

	public List<FlightDTO> getFlightsDTO() {
		return flightsDTO;
	}

	public void setFlightsDTO(List<FlightDTO> flightsDTO) {
		this.flightsDTO = flightsDTO;
	}
	
	

}
