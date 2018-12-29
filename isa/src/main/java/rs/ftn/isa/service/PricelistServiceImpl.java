package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.Pricelist;
import rs.ftn.isa.repository.PricelistRepository;
@Service
public class PricelistServiceImpl implements PricelistService {
	
	@Autowired
	private PricelistRepository pricelistRepository;

	@Override
	public Pricelist getOne(Long id) {
		return pricelistRepository.getOne(id);
	}

	@Override
	public List<Pricelist> getAll() {
		return pricelistRepository.findAll();
	}

	@Override
	public Pricelist save(Pricelist pricelist) {
		return pricelistRepository.save(pricelist);
	}

}
