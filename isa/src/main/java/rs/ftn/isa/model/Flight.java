package rs.ftn.isa.model;



import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)	// MOZDA CE SE MENJATI U CALENDAR
	private Date takeOffDate;
	
	@Temporal(TemporalType.TIME)
	private Date takeOffTime;
	
	@Temporal(TemporalType.DATE)
	private Date landDate;
	
	@Temporal(TemporalType.TIME)
	private Date landTime;
	
	@Column
	private float distance;
	
	@ElementCollection
	@CollectionTable(name="stops")
	private List<String> stops;
	
	@ManyToOne
	private Airline airline;
	
	public Flight(Long id, Date takeOffDate, Date takeOffTime, Date landDate, Date landTime, float distance,
			List<String> stops, Airline airline, float price) {
		super();
		this.id = id;
		this.takeOffDate = takeOffDate;
		this.takeOffTime = takeOffTime;
		this.landDate = landDate;
		this.landTime = landTime;
		this.distance = distance;
		this.stops = stops;
		this.airline = airline;
		this.price = price;
	}

	@Column
	private float price;

	

	public Flight() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getStops() {
		return stops;
	}

	public void setStops(List<String> stops) {
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
	
}