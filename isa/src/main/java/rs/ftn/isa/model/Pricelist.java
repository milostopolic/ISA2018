package rs.ftn.isa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pricelist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "pricelist")
	private List<AdditionalService> additionalServices;	 
	
	@OneToOne
	private Hotel hotel;

	

	public Pricelist(Long id, List<AdditionalService> additionalServices, Hotel hotel) {
		super();
		this.id = id;
		this.additionalServices = additionalServices;
		this.hotel = hotel;
	}

	public Pricelist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}
	
	

}
