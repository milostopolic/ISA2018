package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.Stop;
import rs.ftn.isa.repository.StopRepository;


@Service
public class StopServiceImpl implements StopService {

	@Autowired
	private StopRepository stopRepository;
	
	@Override
	public Stop getOne(Long id) {
		// TODO Auto-generated method stub
		return stopRepository.getOne(id);
	}

	@Override
	public List<Stop> getAll() {
		// TODO Auto-generated method stub
		return stopRepository.findAll();
	}

	
	
}
