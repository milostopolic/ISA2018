package rs.ftn.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BranchOffice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String address;
	
	@ManyToOne
	private RentACar headOffice;

	public BranchOffice(Long id, String address, RentACar headOffice) {
		super();
		this.id = id;
		this.address = address;
		this.headOffice = headOffice;
	}

	public BranchOffice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public RentACar getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(RentACar headOffice) {
		this.headOffice = headOffice;
	}
	
}
