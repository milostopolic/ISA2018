package rs.ftn.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.Room;
import rs.ftn.isa.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room getOne(Long id) {
		// TODO Auto-generated method stub
		return roomRepository.getOne(id);
	}

	@Override
	public Room save(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	@Override
	public void delete(Room room) {
		// TODO Auto-generated method stub
		roomRepository.delete(room);
	}

}
