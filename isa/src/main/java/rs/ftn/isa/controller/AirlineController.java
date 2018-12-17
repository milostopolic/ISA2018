package rs.ftn.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.AirlineDTO;
import rs.ftn.isa.model.Airline;
import rs.ftn.isa.service.AirlineService;

@RestController
@RequestMapping("/api/airlines")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<AirlineDTO> getAirlineById(@PathVariable Long id) {
		Airline airline = airlineService.getOne(id);
		if(airline != null) {
			AirlineDTO airlineDTO = new AirlineDTO(airline);
			return new ResponseEntity<AirlineDTO>(airlineDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<AirlineDTO>> getAll() {
		List<Airline> airlines = airlineService.getAll();
		if(airlines != null) {
			List<AirlineDTO> airlinesDTO = new ArrayList<>();
			for(Airline a : airlines) {
				airlinesDTO.add(new AirlineDTO(a));
			}
			return new ResponseEntity<List<AirlineDTO>>(airlinesDTO, HttpStatus.OK);
		}
		return null;
	}

}
