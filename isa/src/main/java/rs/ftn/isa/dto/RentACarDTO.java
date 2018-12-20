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
	
	private String image;

	public RentACarDTO(Long id, String name, String address, String description,
			List<BranchOfficeDTO> branchOfficesDTO, List<VehicleDTO> vehiclesDTO, String image) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.branchOfficesDTO = branchOfficesDTO;
		this.vehiclesDTO = vehiclesDTO;
		this.image = image;
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
		this.description = rac.getDescription();
		this.branchOfficesDTO = branchOfficesDTO;
		this.vehiclesDTO = vehiclesDTO;
		this.image = rac.getImage();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<BranchOfficeDTO> getBranchOfficesDTO() {
		return branchOfficesDTO;
	}

	public void setBranchOfficesDTO(List<BranchOfficeDTO> branchOfficesDTO) {
		this.branchOfficesDTO = branchOfficesDTO;
	}

	public List<VehicleDTO> getVehiclesDTO() {
		return vehiclesDTO;
	}

	public void setVehiclesDTO(List<VehicleDTO> vehiclesDTO) {
		this.vehiclesDTO = vehiclesDTO;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
