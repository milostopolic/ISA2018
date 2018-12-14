package rs.ftn.isa.service;

import java.util.List;

import rs.ftn.isa.model.Airline;

public interface AirlineService {
	
	Airline getOne(Long id);
	List<Airline> getAll();
	Airline save(Airline airline);
	
}
