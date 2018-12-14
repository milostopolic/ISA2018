package rs.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
		Hotel hotel = hotelService.getOne(id);
		if(hotel != null) {
			return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
		}
		return null;
	} 
	
	@RequestMapping("/all")
	public ResponseEntity<List<Hotel>> getAll() {
		List<Hotel> hotels = hotelService.getAll();
		if(hotels != null) {
			return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
		}
		return null;
	}
}
