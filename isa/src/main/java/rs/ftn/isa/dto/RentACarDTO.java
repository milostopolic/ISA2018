package rs.ftn.isa.dto;

import java.util.ArrayList;
import java.util.List;

import rs.ftn.isa.model.BranchOffice;
import rs.ftn.isa.model.RentACar;
import rs.ftn.isa.model.Vehicle;

public class RentACarDTO {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String description;
	
	private List<BranchOfficeDTO> branchOfficesDTO;
	
	private List<VehicleDTO> vehiclesDTO;

	public RentACarDTO(Long id, String name, String address, String description,
			List<BranchOfficeDTO> branchOfficesDTO, List<VehicleDTO> vehiclesDTO) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.branchOfficesDTO = branchOfficesDTO;
		this.vehiclesDTO = vehiclesDTO;
	}	
	
	public RentACarDTO(RentACar rac) {
		List<BranchOfficeDTO> branchOfficesDTO = new ArrayList<>();
		for(BranchOffice b : rac.getBranches()) {
			branchOfficesDTO.add(new BranchOfficeDTO(b));
		}
		
		List<VehicleDTO> vehiclesDTO = new ArrayList<>();
		for(Vehicle v : rac.getVehicles()) {
			vehiclesDTO.add(new VehicleDTO(v));
		}
		
		this.id = rac.getId();
		this.name = rac.getName();
		this.address = rac.getAddress();
		this.branchOfficesDTO = branchOfficesDTO;
		this.vehiclesDTO = vehiclesDTO;
	}

	public RentACarDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
