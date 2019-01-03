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

import rs.ftn.isa.dto.AdditionalServiceDTO;
import rs.ftn.isa.model.AdditionalService;
import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.service.AdditionalServiceService;
import rs.ftn.isa.service.HotelService;

@RestController
@RequestMapping("/api/additionalservices")
//@CrossOrigin(origins = "http://localhost:4200")
public class AdditionalServiceController {

	@Autowired
	private AdditionalServiceService additionalServiceService;
	
	@Autowired
	private HotelService hotelService;
	
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
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteAdditionalService(@PathVariable Long id) {
		additionalServiceService.delete(additionalServiceService.getOne(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/add/{id}", method=RequestMethod.POST)
	public ResponseEntity<AdditionalServiceDTO> addAdditionalService(@RequestBody AdditionalServiceDTO asDTO, @PathVariable Long id) {
		AdditionalService newAS = new AdditionalService();
		if(asDTO != null) {
			Hotel hotel = hotelService.getOne(id);
			
			newAS.setName(asDTO.getName());
			newAS.setPrice(asDTO.getPrice());
			newAS.setPricelist(hotel.getPricelist());
			
			additionalServiceService.save(newAS);
			
			hotel.getPricelist().getAdditionalServices().add(newAS);
			
			hotelService.save(hotel);
			
			AdditionalServiceDTO newAsDTO = new AdditionalServiceDTO(newAS);
			return new ResponseEntity<AdditionalServiceDTO>(newAsDTO, HttpStatus.OK);		
		}
		
		return null;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public ResponseEntity<AdditionalServiceDTO> editAdditionalService(@RequestBody AdditionalService asDTO, @PathVariable Long id) {
		AdditionalService additionalService = additionalServiceService.getOne(id);
		if(asDTO != null) {
			additionalService.setName(asDTO.getName());
			additionalService.setPrice(asDTO.getPrice());
			
			additionalServiceService.save(additionalService);
			
			AdditionalServiceDTO newAsDTO = new AdditionalServiceDTO(additionalService);
			return new ResponseEntity<AdditionalServiceDTO>(newAsDTO, HttpStatus.OK);
		}
		
		return null;
	}
	
}
