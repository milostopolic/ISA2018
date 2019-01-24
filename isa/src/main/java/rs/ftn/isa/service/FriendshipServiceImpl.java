package rs.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.Friendship;
import rs.ftn.isa.model.FriendshipStatus;
import rs.ftn.isa.model.User;
import rs.ftn.isa.repository.FriendshipRepository;
import rs.ftn.isa.repository.UserRepository;

@Service
public class FriendshipServiceImpl implements FriendshipService {

	@Autowired
	private FriendshipRepository friendshipRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Friendship getOne(Long id) {
		// TODO Auto-generated method stub
		return friendshipRepository.getOne(id);
	}

	@Override
	public List<Friendship> getAll() {
		// TODO Auto-generated method stub
		return friendshipRepository.findAll();
	}
	
	@Override
	public Friendship save(Friendship friendship) {
		// TODO Auto-generated method stub
		return friendshipRepository.save(friendship);
	}
	
	@Override
	public List<User> getFriendshipsPending(User user) {
		List<Friendship> friendships = friendshipRepository.findAll();
		List<User> listaprijatelja = new ArrayList<User>();
		for(Friendship one_friendship : friendships) { 
			if(one_friendship.getStatus().equals(FriendshipStatus.PENDING)) {
				if(one_friendship.getReceiver().equals(user)) { 
					listaprijatelja.add(one_friendship.getSender());
				}
				
			}
			
		}
		
		return listaprijatelja; 
	}

	@Override
	public void sendFriendrequest(User sender, User receiver) {
		// TODO Auto-generated method stub
		
		Friendship friendship = new Friendship(sender, receiver, FriendshipStatus.PENDING);
		friendshipRepository.save(friendship);
		
	}

	@Override
	public List<User> getFriends(User user) {
		// TODO Auto-generated method stub
		
		List<Friendship> friendships = friendshipRepository.findAll();
		List<User> listaprijatelja = new ArrayList<User>();
		for(Friendship one_friendship : friendships) { 
			if(one_friendship.getStatus().equals(FriendshipStatus.ACCEPT)) {
				if(one_friendship.getReceiver().equals(user)) { 
					
					listaprijatelja.add(one_friendship.getSender());
				}
				if(one_friendship.getSender().equals(user)) { 
					listaprijatelja.add(one_friendship.getReceiver());
				}
				
			}
			
		}
		
		return listaprijatelja;
	}

	@Override
	public void acceptFriendrequest(User user_receiver, User user_sender) {
		// TODO Auto-generated method stub
		List<Friendship> friendships = friendshipRepository.findAll();

		for(Friendship one_friendship : friendships) { 
			if(one_friendship.getStatus().equals(FriendshipStatus.PENDING)) {

				if(one_friendship.getReceiver().equals(user_receiver) 
						&& one_friendship.getSender().equals(user_sender)) { 

					one_friendship.setStatus(FriendshipStatus.ACCEPT);
					save(one_friendship);
									
					}
			
				}
		
		}
	}

	@Override
	public void declineFriendrequest(User user_receiver, User user_sender) {
		// TODO Auto-generated method stub
		List<Friendship> friendships = friendshipRepository.findAll();

		for(Friendship one_friendship : friendships) { 
			if(one_friendship.getStatus().equals(FriendshipStatus.PENDING)) {

				if(one_friendship.getReceiver().equals(user_receiver) 
						&& one_friendship.getSender().equals(user_sender)) { 

					one_friendship.setStatus(FriendshipStatus.DECLINED);
					save(one_friendship);
									
					}
			
				}
		
		}
	}

	@Override
	public void deleteFriend(User deletedFriend, User userOwner) {
		// TODO Auto-generated method stub
		List<Friendship> friendships = friendshipRepository.findAll();
		for(Friendship one_friendship : friendships) { 
			if(one_friendship.getStatus().equals(FriendshipStatus.ACCEPT)) {
				
				if(one_friendship.getReceiver().equals(deletedFriend) 
						&& one_friendship.getSender().equals(userOwner)) { 
					System.out.println(deletedFriend.getName() + " udjoh?");
					friendshipRepository.delete(friendshipRepository.getOne(one_friendship.getId()));
									
					}else if(one_friendship.getReceiver().equals(userOwner) 
						&& one_friendship.getSender().equals(deletedFriend)) {
						System.out.println("udjoh?2");
					friendshipRepository.delete(friendshipRepository.getOne(one_friendship.getId()));
					}
			
				}
		
		}
	}

	@Override
	public List<User> getSuggested(User user) {
		// TODO Auto-generated method stub
		List<User> listaSuggested = new ArrayList<User>();
		List<User> listaKorisnika = userRepository.findAll();
		List<User> pendings = getFriendshipsPending(user);
		List<Friendship> friendships = friendshipRepository.findAll();
		List<User> friends = getFriends(user);
		for(User one_user : listaKorisnika) {
			if(!friends.contains(one_user) && !pendings.contains(one_user)) {
				if(one_user != user) {
					listaSuggested.add(one_user);
				}
				
			}
		}
					
		return listaSuggested;
	}
	
	

	
	
}
