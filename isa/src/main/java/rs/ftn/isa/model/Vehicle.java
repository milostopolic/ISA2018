package rs.ftn.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String manufacturer;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private int productionYear;
	
	@Column(nullable = false)
	private int seats;
	
	@Column(nullable = false)
	private VehicleType type;
	
	@Column(nullable = false)
	private float price;
	
	@ManyToOne
	private RentACar rentACar;

	public Vehicle(Long id, String manufacturer, String model, int productionYear, int seats, VehicleType type,
			float price, RentACar rentACar) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.productionYear = productionYear;
		this.seats = seats;
		this.type = type;
		this.price = price;
		this.rentACar = rentACar;
	}	

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public RentACar getRentACar() {
		return rentACar;
	}

	public void setRentACar(RentACar rentACar) {
		this.rentACar = rentACar;
	}
	
	

}
