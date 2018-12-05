package rs.ftn.isa.dto;

import rs.ftn.isa.model.User;

public class UserDTO {
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String phoneNmbr;
	
	private boolean verified;

	public UserDTO(Long id, String name, String surname, String email, String password, String address,
			String phoneNmbr, boolean verified) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNmbr = phoneNmbr;
		this.verified = verified;
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhoneNmbr(),user.isVerified());
	}


	public UserDTO() {
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


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNmbr() {
		return phoneNmbr;
	}


	public void setPhoneNmbr(String phoneNmbr) {
		this.phoneNmbr = phoneNmbr;
	}


	public boolean isVerified() {
		return verified;
	}


	public void setVerified(boolean verified) {
		this.verified = verified;
	}


	
	
	
}
