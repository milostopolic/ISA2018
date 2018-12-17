package rs.ftn.isa.dto;

import java.util.Date;
import java.util.List;

import rs.ftn.isa.model.Flight;

public class FlightDTO {
	
	private Long id;
	
	private String departurePlace;
	
	private String destination;
	
	private Date takeOffDate;
	
	private Date takeOffTime;
	
	private Date landDate;
	
	private Date landTime;
	
	private float distance;
	
	private float price;
	
	private List<String> stops;
	
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
		this.stops = f.getStops();
		//this.airlineDTO = new AirlineDTO(f.getAirline());
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

	public Date getTakeOffDate() {
		return takeOffDate;
	}

	public void setTakeOffDate(Date takeOffDate) {
		this.takeOffDate = takeOffDate;
	}

	public Date getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(Date takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public Date getLandDate() {
		return landDate;
	}

	public void setLandDate(Date landDate) {
		this.landDate = landDate;
	}

	public Date getLandTime() {
		return landTime;
	}

	public void setLandTime(Date landTime) {
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

	public List<String> getStops() {
		return stops;
	}

	public void setStops(List<String> stops) {
		this.stops = stops;
	}

	/*public AirlineDTO getAirlineDTO() {
		return airlineDTO;
	}

	public void setAirlineDTO(AirlineDTO airlineDTO) {
		this.airlineDTO = airlineDTO;
	}*/
	
	

}
