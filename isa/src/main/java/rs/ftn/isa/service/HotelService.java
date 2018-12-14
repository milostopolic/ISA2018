package rs.ftn.isa.service;

import java.util.List;
import rs.ftn.isa.model.Hotel;

public interface HotelService {

	Hotel getOne(Long id);
	List<Hotel> getAll();
	Hotel save(Hotel hotel);
	
}
