package rs.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.model.Airline;
import rs.ftn.isa.service.AirlineService;

@RestController
@RequestMapping("/api/airlines")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<Airline> getAirlineById(@PathVariable Long id) {
		Airline airline = airlineService.getOne(id);
		if(airline != null) {
			return new ResponseEntity<Airline>(airline, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<List<Airline>> getAll() {
		List<Airline> airlines = airlineService.getAll();
		if(airlines != null) {
			return new ResponseEntity<List<Airline>>(airlines, HttpStatus.OK);
		}
		return null;
	}

}
