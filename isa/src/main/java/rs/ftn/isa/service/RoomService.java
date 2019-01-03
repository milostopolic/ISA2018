package rs.ftn.isa.service;

import rs.ftn.isa.model.Room;

public interface RoomService {
	
	Room getOne(Long id);
	Room save(Room room);
	void delete(Room room);

}
