package rs.ftn.isa.service;

import java.util.List;

import rs.ftn.isa.model.Stop;

public interface StopService {

	Stop getOne(Long id);
	List<Stop> getAll();
	
}
