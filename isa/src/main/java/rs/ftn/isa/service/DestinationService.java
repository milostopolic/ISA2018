package rs.ftn.isa.service;

import rs.ftn.isa.model.Destination;

public interface DestinationService {
	
	Destination getOne(Long id);
	Destination save(Destination destination);
	void delete(Destination destination);
	Destination update(Destination oldDestination, Destination newDestination);
	
}
