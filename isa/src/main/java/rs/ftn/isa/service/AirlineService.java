package rs.ftn.isa.service;

import java.util.List;

import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.Destination;

public interface AirlineService {
	
	Airline getOne(Long id);
	List<Airline> getAll();
	Airline save(Airline airline);	
	Airline update(Airline oldAirline,Airline newAirline);
	
}
