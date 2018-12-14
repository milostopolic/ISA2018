package rs.ftn.isa.service;

import java.util.List;

import rs.ftn.isa.model.RentACar;

public interface RentACarService {
	
	RentACar getOne(Long id);
	List<RentACar> getAll();
	RentACar save(RentACar rentACar);

}
