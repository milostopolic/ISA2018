package rs.ftn.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.AirlineDTO;
import rs.ftn.isa.dto.DestinationDTO;
import rs.ftn.isa.dto.FlightDTO;
import rs.ftn.isa.dto.StopDTO;
import rs.ftn.isa.dto.UserDTO;
import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.Destination;
import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Stop;
import rs.ftn.isa.model.User;
import rs.ftn.isa.service.AirlineService;
import rs.ftn.isa.service.DestinationService;
import rs.ftn.isa.service.FlightService;
import rs.ftn.isa.service.StopService;

@RestController
@RequestMapping("/api/airlines")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private StopService stopService;
	
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
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<AirlineDTO> update(@RequestBody Airline airline, @PathVariable Long id){
		Airline oldAirline = airlineService.getOne(id);		
		if(oldAirline != null) {
			Airline newAirline = airlineService.update(oldAirline, airline);
			return new ResponseEntity<AirlineDTO>(new AirlineDTO(newAirline), HttpStatus.OK);
		}
			return null;
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AirlineDTO> addAirline(@RequestBody AirlineDTO airDTO){
		Airline air = new Airline();
		air.setAddress(airDTO.getAddress());
		air.setDescription(airDTO.getDescription());
		air.setName(airDTO.getName());
		air.setDestinations(new ArrayList<Destination>());
		air = airlineService.save(air);
		return new ResponseEntity<AirlineDTO>(new AirlineDTO(air), HttpStatus.CREATED);
	}
	
							/* DESTINATION CONTROLLER */
	
	@RequestMapping(value = "/addDestination/{id}", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
		public ResponseEntity<DestinationDTO> addDestinationToAirline(@RequestBody DestinationDTO destDTO, @PathVariable Long id){
			Destination destin = new Destination();
			destin.setName(destDTO.getName());
			Airline air = airlineService.getOne(id);
			destin.setAirline(air);
			destin = destinationService.save(destin);
			air.getDestinations().add(destin);
			air = airlineService.save(air);
			return new ResponseEntity<DestinationDTO>(new DestinationDTO(destin), HttpStatus.CREATED);
		}
	
	@RequestMapping(value="/deleteDestination/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDestination(@PathVariable Long id) {
		destinationService.delete(destinationService.getOne(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/editDestination/{id}", method=RequestMethod.PUT)
	public ResponseEntity<DestinationDTO> update(@RequestBody Destination destination, @PathVariable Long id){
		Destination oldDestination = destinationService.getOne(id);
		Airline airl = airlineService.getOne(oldDestination.getAirline().getId());
		if(oldDestination != null) {
			for(Destination d : airl.getDestinations()) {
				System.out.println(d.getName() + " " + destination.getName() + "!!!!!!!!!!!!!!!!!");
				if(d.getName().equals(destination.getName())) {
					System.out.println("usao!!#@#@#@");
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			Destination newDestination = destinationService.update(oldDestination, destination);
			return new ResponseEntity<DestinationDTO>(new DestinationDTO(newDestination), HttpStatus.OK);
		}else {
			return null;
		}
	}
	
							/* STOP CONTROLLER */
	
	@RequestMapping(value="/allStops")
		public ResponseEntity<List<StopDTO>> getAllStops(){
		List<Stop> stops = stopService.getAll();
		if(stops != null) {
			List<StopDTO> stopsDTO = new ArrayList<>();
			for(Stop s : stops) {
				stopsDTO.add(new StopDTO(s));
			}
			return new ResponseEntity<List<StopDTO>>(stopsDTO, HttpStatus.OK);
		}
		return null;
	}
	
							/* FLIGHT CONTROLLER */
	
	@RequestMapping(value = "/addFlight/{id}", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)	
		public ResponseEntity<FlightDTO> addFlightToAirline(@RequestBody FlightDTO fligDTO, @PathVariable Long id){
			Flight flig = new Flight();
			flig.setDeparturePlace(fligDTO.getDeparturePlace());
			flig.setDestination(fligDTO.getDestination());
			flig.setTakeOffDate(fligDTO.getTakeOffDate());
			flig.setTakeOffTime(fligDTO.getTakeOffTime());
			flig.setLandDate(fligDTO.getLandDate());
			flig.setLandTime(fligDTO.getLandTime());
			flig.setDistance(fligDTO.getDistance());
			flig.setStops(new ArrayList<Stop>()); //za sad ovde ide prazna lista, treba promeniti
			flig.setPrice(fligDTO.getPrice());
			Airline air = airlineService.getOne(id);
			flig.setAirline(air);
			flig = flightService.save(flig);
			air.getFlights().add(flig);
			air = airlineService.save(air);
			
			return new ResponseEntity<FlightDTO>(new FlightDTO(flig), HttpStatus.CREATED);		
	}	
	
	@RequestMapping(value="/deleteFlight/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
		flightService.delete(flightService.getOne(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/editFlight/{id}", method=RequestMethod.PUT)
	public ResponseEntity<FlightDTO> update(@RequestBody Flight flight, @PathVariable Long id){
		Flight oldFlight = flightService.getOne(id);
		//Airline airl = airlineService.getOne(oldFlight.getAirline().getId());
		if(oldFlight != null) {			
			Flight newFlight = flightService.update(oldFlight, flight);
			return new ResponseEntity<FlightDTO>(new FlightDTO(newFlight), HttpStatus.OK);
		}else {
			return null;
		}
	}
		

}
