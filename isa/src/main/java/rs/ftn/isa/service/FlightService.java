package rs.ftn.isa.service;

import rs.ftn.isa.model.Flight;

public interface FlightService {

	Flight getOne(Long id);
	Flight save(Flight flight);
	void delete(Flight flight);
	
}
