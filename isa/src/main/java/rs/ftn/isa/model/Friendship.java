package rs.ftn.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Friendship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	private User sender;
	
	@ManyToOne
	private User receiver;
	
	@Column(name="status")
	private FriendshipStatus status;
	
	@Column(name="confirm")
	private String confirm;

	
	public Friendship() {
		super();
	}

	public Friendship(User sender, User receiver, FriendshipStatus status) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
	}

	public Friendship(Long id, User sender, User receiver,
			FriendshipStatus status, String confirm) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
		this.confirm = confirm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public FriendshipStatus getStatus() {
		return status;
	}

	public void setStatus(FriendshipStatus status) {
		this.status = status;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	
	
}