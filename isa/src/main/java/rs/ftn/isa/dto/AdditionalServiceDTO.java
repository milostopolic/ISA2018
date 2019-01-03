package rs.ftn.isa.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import rs.ftn.isa.model.AdditionalService;

public class AdditionalServiceDTO {
	
	private Long id;
	
	private String name;
	
	private float price;
	
	private Long parentID;
	
	
	public AdditionalServiceDTO (AdditionalService as) {
		this.id = as.getId();
		this.name = as.getName();
		this.price = as.getPrice();
		this.parentID = as.getPricelist().getId();
	}
	
	public AdditionalServiceDTO() {
		
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


	public Long getParentID() {
		return parentID;
	}


	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}
	
	

}
