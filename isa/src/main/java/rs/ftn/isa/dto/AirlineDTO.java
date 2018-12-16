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
	
	private List<String> destionations;
	
	private List<FlightDTO> flightsDTO;	
	
	public AirlineDTO(Long id, String name, String address, String description, List<String> destionations,
			List<FlightDTO> flightsDTO) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.destionations = destionations;
		this.flightsDTO = flightsDTO;
	}

	public AirlineDTO(Airline airline) {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		for(Flight f : airline.getFlights()) {
			flightsDTO.add(new FlightDTO(f));
		}
		this.id = airline.getId();
		this.name = airline.getName();
		this.address = airline.getAddress();
		this.description = airline.getDescription();
		this.destionations = airline.getDestinations();
		this.flightsDTO = flightsDTO;
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
