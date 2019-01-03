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

import rs.ftn.isa.dto.PricelistDTO;
import rs.ftn.isa.model.Pricelist;
import rs.ftn.isa.service.PricelistService;

@RestController
@RequestMapping("/api/pricelists")
//@CrossOrigin(origins = "http://localhost:4200")
public class PricelistController {

	@Autowired
	private PricelistService pricelistService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<PricelistDTO> getPricelistById(@PathVariable Long id) {
		Pricelist pricelist = pricelistService.getOne(id);
		if(pricelist != null) {
			PricelistDTO pricelistDTO = new PricelistDTO(pricelist);
			return new ResponseEntity<PricelistDTO>(pricelistDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping("/all")
	public ResponseEntity<List<PricelistDTO>> getAll() {
		List<Pricelist> pricelists = pricelistService.getAll();
		if(pricelists != null) {
			List<PricelistDTO> pricelistsDTO = new ArrayList<>();
			for(Pricelist p : pricelists) {
				pricelistsDTO.add(new PricelistDTO(p));
			}
			return new ResponseEntity<List<PricelistDTO>>(pricelistsDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	
}
