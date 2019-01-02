package rs.ftn.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.Flight;
import rs.ftn.isa.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public Flight getOne(Long id) {
		// TODO Auto-generated method stub
		return flightRepository.getOne(id);
	}

	@Override
	public Flight save(Flight flight) {
		// TODO Auto-generated method stub
		return flightRepository.save(flight);
	}

	@Override
	public void delete(Flight flight) {
		// TODO Auto-generated method stub
		flightRepository.delete(flight);
	}

}
