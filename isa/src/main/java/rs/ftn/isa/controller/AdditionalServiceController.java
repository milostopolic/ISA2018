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

import rs.ftn.isa.dto.AdditionalServiceDTO;
import rs.ftn.isa.model.AdditionalService;
import rs.ftn.isa.service.AdditionalServiceService;

@RestController
@RequestMapping("/api/additionalservices")
@CrossOrigin(origins = "http://localhost:4200")
public class AdditionalServiceController {

	@Autowired
	private AdditionalServiceService additionalServiceService;
	
	@RequestMapping("/allbypricelist/{id}")
	public ResponseEntity<List<AdditionalServiceDTO>> getAllByPricelistId(@PathVariable Long id) {
		List<AdditionalService> as =  additionalServiceService.findByPricelist_Id(id);
		if(as != null ) {
			List<AdditionalServiceDTO> asDTO = new ArrayList<>();
			for(AdditionalService a : as) {
				asDTO.add(new AdditionalServiceDTO(a));
			}
			return new ResponseEntity<List<AdditionalServiceDTO>>(asDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<AdditionalServiceDTO> getAdditionalServiceById(@PathVariable Long id) {
		AdditionalService additionalService = additionalServiceService.getOne(id);
		if(additionalService != null) {
			AdditionalServiceDTO additionalServiceDTO = new AdditionalServiceDTO(additionalService);
			return new ResponseEntity<AdditionalServiceDTO>(additionalServiceDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<AdditionalServiceDTO>> getAll() {
		List<AdditionalService> as =  additionalServiceService.getAll();
		if(as != null ) {
			List<AdditionalServiceDTO> asDTO = new ArrayList<>();
			for(AdditionalService a : as) {
				asDTO.add(new AdditionalServiceDTO(a));
			}
			return new ResponseEntity<List<AdditionalServiceDTO>>(asDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	
}
