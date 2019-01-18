package rs.ftn.isa.service;

import java.util.List;

import rs.ftn.isa.model.Friendship;
import rs.ftn.isa.model.User;

public interface FriendshipService {

	Friendship getOne(Long id);
	Friendship save(Friendship friendship);
	List<Friendship> getAll();
	
	void sendFriendrequest(User sender, User receiver);
	List<User> getFriendshipsPending(User user);
	List<User> getFriends(User user);
	void acceptFriendrequest(User user_receiver, User user_sender);
	void declineFriendrequest(User user_receiver, User user_sender);
	void deleteFriend(User user_receiver, User user_sender);
	
	List<User> getSuggested(User user);
	
}
