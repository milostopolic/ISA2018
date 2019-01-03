package rs.ftn.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.RoomDTO;
import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.model.Room;
import rs.ftn.isa.service.HotelService;
import rs.ftn.isa.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
//@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) {
		Room room =  roomService.getOne(id);
		if(room != null) {
			RoomDTO roomDTO = new RoomDTO(room);
			return new ResponseEntity<RoomDTO>(roomDTO, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/add/{id}", method=RequestMethod.POST)
	public ResponseEntity<RoomDTO> addRoom(@RequestBody RoomDTO roomDTO, @PathVariable Long id) {
		Room newRoom = new Room();
		if(roomDTO != null) {
			Hotel hotel = hotelService.getOne(id);
			System.out.println("USAO U IFF");
			newRoom.setBeds(roomDTO.getBeds());
			newRoom.setPrice(roomDTO.getPrice());
			newRoom.setHotel(hotel);
			
			roomService.save(newRoom);
			
			hotel.getRooms().add(newRoom);
			
			hotelService.save(hotel);
			
			RoomDTO newRoomDTO = new RoomDTO(newRoom);
			return new ResponseEntity<RoomDTO>(newRoomDTO, HttpStatus.OK);
		}
		System.out.println("NIJE USAO U IFF");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
		roomService.delete(roomService.getOne(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public ResponseEntity<RoomDTO> editRoom(@RequestBody RoomDTO roomDTO, @PathVariable Long id) {
		Room room = roomService.getOne(id);
		if(roomDTO != null) {
			room.setBeds(roomDTO.getBeds());
			room.setPrice(roomDTO.getPrice());
			
			roomService.save(room);
			
			RoomDTO newRoomDTO = new RoomDTO(room);
			return new ResponseEntity<RoomDTO>(newRoomDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
