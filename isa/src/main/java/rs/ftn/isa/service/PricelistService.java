package rs.ftn.isa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ftn.isa.model.Pricelist;


public interface PricelistService {
	
	Pricelist getOne(Long id);
	List<Pricelist> getAll();
	Pricelist save(Pricelist pricelist);

}
