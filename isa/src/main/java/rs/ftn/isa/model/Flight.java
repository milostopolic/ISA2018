package rs.ftn.isa.model;



import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String departurePlace;
	
	@Column
	private String destination;
	
	@Column	// MOZDA CE SE MENJATI U CALENDAR
	private String takeOffDate;
	
	@Column
	private String takeOffTime;
	
	@Column
	private String landDate;
	
	@Column
	private String landTime;
	
	@Column
	private float distance;
	
	@OneToMany(mappedBy = "flight")
	private List<Stop> stops;
	
	@ManyToOne
	private Airline airline;
	
	@Column
	private float price;
	
	public Flight(Long id,String departurePlace, String destination, String takeOffString, String takeOffTime, String landString, String landTime, float distance,
			List<Stop> stops, Airline airline, float price) {
		super();
		this.id = id;
		this.departurePlace = departurePlace;
		this.destination = destination;
		this.takeOffDate = takeOffString;
		this.takeOffTime = takeOffTime;
		this.landDate = landString;
		this.landTime = landTime;
		this.distance = distance;
		this.stops = stops;
		this.airline = airline;
		this.price = price;
	}

	

	

	public Flight() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTakeOffDate() {
		return takeOffDate;
	}

	public void setTakeOffDate(String takeOffDate) {
		this.takeOffDate = takeOffDate;
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

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
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
	
}
