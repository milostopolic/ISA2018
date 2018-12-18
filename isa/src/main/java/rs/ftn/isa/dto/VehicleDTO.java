package rs.ftn.isa.dto;

import rs.ftn.isa.model.Vehicle;
import rs.ftn.isa.model.VehicleType;

public class VehicleDTO {
	
	private Long id;
	
	private String manufacturer;
	
	private String model;
	
	private int productionYear;
	
	private int seats;
	
	private VehicleType type;
	
	private float price;

	public VehicleDTO(Long id, String manufacturer, String model, int productionYear, int seats, VehicleType type,
			float price) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.productionYear = productionYear;
		this.seats = seats;
		this.type = type;
		this.price = price;
	}
	
	public VehicleDTO(Vehicle v) {
		this.id = v.getId();
		this.manufacturer = v.getManufacturer();
		this.model = v.getModel();
		this.productionYear = v.getProductionYear();
		this.seats = v.getSeats();
		this.type = v.getType();
		this.price = v.getPrice();
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

}
