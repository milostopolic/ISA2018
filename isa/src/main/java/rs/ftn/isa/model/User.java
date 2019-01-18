package rs.ftn.isa.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)	
	private String name;
	
	@Column(nullable = false)	
	private String surname;
	
	@Column(nullable = false)	
	private String email;
	
	@Column(nullable = false)	
	private String password;
	
	@Column	
	private String address;
	
	@Column	
	private String phoneNmbr;
	
	@Column
	private boolean verified;
	
	@OneToMany(mappedBy = "sender")
	private Set<Friendship> friendship = new HashSet<Friendship>();;

	@OneToMany(mappedBy = "receiver")
	private Set<Friendship> friendshipReceiver = new HashSet<Friendship>();
		

	public User(Long id, String name, String surname, String email, String password, String address, String phoneNmbr,
			boolean verified) {
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

	public User() {
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

	public Set<Friendship> getFriendship() {
		return friendship;
	}

	public void setFriendship(Set<Friendship> friendship) {
		this.friendship = friendship;
	}

	public Set<Friendship> getFriendshipReceiver() {
		return friendshipReceiver;
	}

	public void setFriendshipReceiver(Set<Friendship> friendshipReceiver) {
		this.friendshipReceiver = friendshipReceiver;
	}
	
	
	
	
}
