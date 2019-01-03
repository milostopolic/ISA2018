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

import rs.ftn.isa.dto.RentACarDTO;
import rs.ftn.isa.model.RentACar;
import rs.ftn.isa.service.RentACarService;

@RestController
@RequestMapping("/api/rentacars")
//@CrossOrigin(origins = "http://localhost:4200")
public class RentACarController {
	
	@Autowired
	private RentACarService rentACarService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<RentACarDTO> getRentACarById(@PathVariable Long id) {
		RentACar rentACar = rentACarService.getOne(id);
		if(rentACar != null) {
			RentACarDTO rentACarDTO = new RentACarDTO(rentACar);
			return new ResponseEntity<RentACarDTO>(rentACarDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<RentACarDTO>> getAll() {
		List<RentACar> rentACars = rentACarService.getAll();
		if(rentACars != null) {
			List<RentACarDTO> rentACarsDTO = new ArrayList<RentACarDTO>();
			for(RentACar r : rentACars) {
				rentACarsDTO.add(new RentACarDTO(r));
			}
			return new ResponseEntity<List<RentACarDTO>>(rentACarsDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
