package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.Destination;
import rs.ftn.isa.model.User;
import rs.ftn.isa.repository.AirlineRepository;
import rs.ftn.isa.repository.DestinationRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;
	
		
	@Override
	public Airline getOne(Long id) {
		// TODO Auto-generated method stub
		return airlineRepository.getOne(id);
	}

	@Override
	public List<Airline> getAll() {
		// TODO Auto-generated method stub
		return airlineRepository.findAll();
	}

	@Override
	public Airline save(Airline airline) {
		// TODO Auto-generated method stub
		return airlineRepository.save(airline);
	}

	@Override
	public Airline update(Airline oldAirline, Airline newAirline) {
		// TODO Auto-generated method stub
		if(newAirline.getName() != null){
			oldAirline.setName(newAirline.getName());
		}		
		if(newAirline.getAddress() != null){
			oldAirline.setAddress(newAirline.getAddress());
		}
		if(newAirline.getDescription() != null){
			oldAirline.setDescription(newAirline.getDescription());
		}
		
		
		return airlineRepository.save(oldAirline);
	}

	

}
