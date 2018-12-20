package rs.ftn.isa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RentACar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)	
	private String name;
	
	@Column(nullable = false)	
	private String address;
	
	@Column(nullable = false)	
	private String description;
	
	@OneToMany(mappedBy = "headOffice")
	private List<BranchOffice> branches;
	
	@OneToMany(mappedBy = "rentACar")
	private List<Vehicle> vehicles;
	
	@Column(nullable = false)	
	private String image;

	public RentACar(Long id, String name, String address, String description, List<BranchOffice> branches,
			List<Vehicle> vehicles, String image) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.branches = branches;
		this.vehicles = vehicles;
		this.image = image;
	}

	public RentACar(Long id, String name, String address, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
	}

	public RentACar() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<BranchOffice> getBranches() {
		return branches;
	}

	public void setBranches(List<BranchOffice> branches) {
		this.branches = branches;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
