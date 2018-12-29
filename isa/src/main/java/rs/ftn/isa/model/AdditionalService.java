package rs.ftn.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AdditionalService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private float price;
	
	@ManyToOne
	private Pricelist pricelist;

	public AdditionalService(Long id, String name, float price, Pricelist pricelist) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pricelist = pricelist;
	}

	public AdditionalService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}
	
	

}
