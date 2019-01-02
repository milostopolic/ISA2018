package rs.ftn.isa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ftn.isa.model.AdditionalService;


public interface AdditionalServiceService {
	
	AdditionalService getOne(Long id);
	List<AdditionalService> getAll();
	List<AdditionalService> findByPricelist_Id(Long id);
	AdditionalService save(AdditionalService additionalService);
	void delete(AdditionalService additionalService);

}
