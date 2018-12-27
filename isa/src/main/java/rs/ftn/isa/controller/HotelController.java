package rs.ftn.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.HotelDTO;
import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
		Hotel hotel = hotelService.getOne(id);
		if(hotel != null) {
			HotelDTO hotelDTO = new HotelDTO(hotel);
			return new ResponseEntity<HotelDTO>(hotelDTO, HttpStatus.OK);
		}
		return null;
	} 
	
	@RequestMapping("/all")
	public ResponseEntity<List<HotelDTO>> getAll() {
		List<Hotel> hotels = hotelService.getAll();
		if(hotels != null) {
			List<HotelDTO> hotelsDTO = new ArrayList<>();
			for(Hotel h : hotels) {
				hotelsDTO.add(new HotelDTO(h));
			}
			return new ResponseEntity<List<HotelDTO>>(hotelsDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<HotelDTO> update(@RequestBody Hotel hotel, @PathVariable Long id) {
		Hotel oldHotel = hotelService.getOne(id);
		if(oldHotel != null) {
			Hotel newHotel = hotelService.update(oldHotel, hotel);
			return new ResponseEntity<HotelDTO>(new HotelDTO(newHotel), HttpStatus.OK);
		}
		return null;
	}
}
