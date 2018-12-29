package rs.ftn.isa.dto;

import java.util.ArrayList;
import java.util.List;

import rs.ftn.isa.model.AdditionalService;
import rs.ftn.isa.model.Pricelist;

public class PricelistDTO {
	
	private Long id;
	
	private List<AdditionalServiceDTO> additionalServicesDTO;
	
	public PricelistDTO(Pricelist pricelist) {
		List<AdditionalServiceDTO> additionalServicesDTO = new ArrayList<>();
		for(AdditionalService as : pricelist.getAdditionalServices()) {
			additionalServicesDTO.add(new AdditionalServiceDTO(as));
		}
		this.id = pricelist.getId();
		this.additionalServicesDTO = additionalServicesDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AdditionalServiceDTO> getAdditionalServicesDTO() {
		return additionalServicesDTO;
	}

	public void setAdditionalServicesDTO(List<AdditionalServiceDTO> additionalServicesDTO) {
		this.additionalServicesDTO = additionalServicesDTO;
	}
	
	
	
	

}
