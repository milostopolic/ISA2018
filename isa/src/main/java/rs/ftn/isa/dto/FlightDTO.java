package rs.ftn.isa.dto;

import java.util.ArrayList;
import java.util.List;

import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Stop;

public class FlightDTO {
	
	private Long id;
	
	private Long airline_id;
	
	private String departurePlace;
	
	private String destination;
	
	private String takeOffDate;
	
	private String takeOffTime;
	
	private String landDate;
	
	private String landTime;
	
	private float distance;
	
	private float price;
	
	private List<StopDTO> stops;
	
	//private AirlineDTO airlineDTO;

	public FlightDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlightDTO(Flight f) {
		this.id = f.getId();
		this.departurePlace = f.getDeparturePlace();
		this.destination = f.getDestination();
		this.takeOffDate = f.getTakeOffDate();
		this.takeOffTime = f.getTakeOffTime();
		this.landDate = f.getLandDate();
		this.landTime = f.getLandTime();
		this.distance = f.getDistance();
		this.price = f.getPrice();
		//this.stops = f.getStops();
		this.stops = new ArrayList<StopDTO>();
		for(Stop s : f.getStops()) {
			stops.add(new StopDTO(s));
		}
		//this.airlineDTO = new AirlineDTO(f.getAirline());
		this.airline_id = f.getAirline().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTakeOffDate() {
		return takeOffDate;
	}

	public void setTakeOffDate(String takeOffString) {
		this.takeOffDate = takeOffString;
	}

	public String getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public String getLandDate() {
		return landDate;
	}

	public void setLandDate(String landString) {
		this.landDate = landString;
	}

	public String getLandTime() {
		return landTime;
	}

	public void setLandTime(String landTime) {
		this.landTime = landTime;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<StopDTO> getStops() {
		return stops;
	}

	public void setStops(List<StopDTO> stops) {
		this.stops = stops;
	}

	public Long getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(Long airline_id) {
		this.airline_id = airline_id;
	}

	/*public AirlineDTO getAirlineDTO() {
		return airlineDTO;
	}

	public void setAirlineDTO(AirlineDTO airlineDTO) {
		this.airlineDTO = airlineDTO;
	}*/
	
	

}
