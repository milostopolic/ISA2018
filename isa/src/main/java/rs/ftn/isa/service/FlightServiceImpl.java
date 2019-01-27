package rs.ftn.isa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Stop;
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

	@Override
	public Flight update(Flight oldFlight, Flight newFlight) {
		// TODO Auto-generated method stub
		if(newFlight.getDeparturePlace() != null) {
			oldFlight.setDeparturePlace(newFlight.getDeparturePlace());
		}
		if(newFlight.getDestination() != null) {
			oldFlight.setDestination(newFlight.getDestination());
		}
		if(newFlight.getTakeOffDate() != null) {
			oldFlight.setTakeOffDate(newFlight.getTakeOffDate().substring(0, 10));
			System.out.println(oldFlight.getTakeOffDate() + " AALDKLSKDSKDSKDSKDSKKDSKDS");
		}
		if(newFlight.getTakeOffTime() != null) {
			oldFlight.setTakeOffTime(newFlight.getTakeOffTime());
		}
		if(newFlight.getLandDate() != null) {
			oldFlight.setLandDate(newFlight.getLandDate().substring(0, 10));
			System.out.println(oldFlight.getLandDate() + " LDKLSKDSKDSKDSKDSKKDSKDS");
		}
		if(newFlight.getLandTime() != null) {
			oldFlight.setLandTime(newFlight.getLandTime());
		}
		if(newFlight.getDistance() != 0) {
			oldFlight.setDistance(newFlight.getDistance());
		}
		if(newFlight.getDistance() != 0) {
			oldFlight.setDistance(newFlight.getDistance());
		}
		oldFlight.setStops(new ArrayList<Stop>()); // ovde stopovi impl
		if(newFlight.getPrice() != 0) {
			oldFlight.setPrice(newFlight.getPrice());
		}
		
		
		return flightRepository.save(oldFlight);
	}

}
