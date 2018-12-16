package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.RentACar;
import rs.ftn.isa.repository.RentACarRepository;

@Service	
public class RentACarServiceImpl implements RentACarService {

	@Autowired
	private RentACarRepository rentACarRepository;

	@Override
	public RentACar getOne(Long id) {
		// TODO Auto-generated method stub
		return rentACarRepository.getOne(id);
	}

	@Override
	public List<RentACar> getAll() {
		// TODO Auto-generated method stub
		return rentACarRepository.findAll();
	}

	@Override
	public RentACar save(RentACar rentACar) {
		// TODO Auto-generated method stub
		return rentACarRepository.save(rentACar);
	}
	
	
	
}
