package rs.ftn.isa.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.UserDTO;
import rs.ftn.isa.model.Friendship;
import rs.ftn.isa.model.User;
import rs.ftn.isa.service.FriendshipService;
import rs.ftn.isa.service.UserService;

@RestController
@RequestMapping("/api/friendship")
@CrossOrigin(origins = "http://localhost:4200")
public class FriendshipController {

	@Autowired
	private FriendshipService friendshipService;
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public String getAllFriendships() {
		List<Friendship> friendships = friendshipService.getAll();
		for(Friendship one_friendship : friendships) {
			User sender = userService.getOne(one_friendship.getSender().getId());
			User receiver = userService.getOne(one_friendship.getReceiver().getId());
			
			System.out.println(sender.getName()	+" je poslao zahtev " + receiver.getName() + " sa statusom " + one_friendship.getStatus());
		}
		return "uspesno";
	}
	
		@RequestMapping(value="/sendRequest/{senderID}/{receiverID}",method = RequestMethod.GET)
		public ResponseEntity<?> sendFriendrequest(@PathVariable Long receiverID, 
				@PathVariable Long senderID){
			User sender = userService.getOne(senderID); 
			User receiver = userService.getOne(receiverID);
			if(sender != null && receiver != null) {
				friendshipService.sendFriendrequest(sender, receiver);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return null;		
		}
		
		@RequestMapping(value="/{id}/friends",method = RequestMethod.GET)
		public ResponseEntity<List<UserDTO>> getFriends(@PathVariable Long id) {
			User user = userService.getOne(id); 
			if(user != null) {
				List<User> listaprijatelja = friendshipService.getFriends(user);
				List<UserDTO> lista = new ArrayList<UserDTO>();
				for(User u : listaprijatelja) {
					lista.add(new UserDTO(u));
				}
				return new ResponseEntity<>(lista, HttpStatus.OK);
			} else {
				return null;
			}
		}
		
		@RequestMapping(value="/{id}/pending",method = RequestMethod.GET)
		public ResponseEntity<List<UserDTO>> getPendingFriendrequests(@PathVariable Long id) {
			User user = userService.getOne(id); 
			if(user != null) {
				List<User> listapending = friendshipService.getFriendshipsPending(user);
				List<UserDTO> lista = new ArrayList<UserDTO>();
				for(User u : listapending) {
					lista.add(new UserDTO(u));
				}
				return new ResponseEntity<>(lista, HttpStatus.OK);
			} else {
				return null;
			}
				
		}
		
		
		@RequestMapping(value="/accept/{receiver_id}/{sender_id}",method = RequestMethod.GET)
		public ResponseEntity<?> acceptFriendrequest(@PathVariable Long receiver_id,
				@PathVariable Long sender_id) {
			
			User user_receiver = userService.getOne(receiver_id);
			User user_sender = userService.getOne(sender_id);
			
			if(user_receiver != null && user_sender != null) {				
				friendshipService.acceptFriendrequest(user_receiver, user_sender);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return null;
			}
			
		}
		
		@RequestMapping(value="/decline/{receiver_id}/{sender_id}",method = RequestMethod.GET)
		public ResponseEntity<?> declineFriendrequest(@PathVariable Long receiver_id,
				@PathVariable Long sender_id) {

			User user_receiver = userService.getOne(receiver_id);
			User user_sender = userService.getOne(sender_id);
			
			if(user_receiver != null && user_sender != null) {
				friendshipService.declineFriendrequest(user_receiver, user_sender);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return null;
			}
			
		}
		
		@RequestMapping(value="/delete/{receiver_id}/{sender_id}",method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteFriend(@PathVariable Long receiver_id,
				@PathVariable Long sender_id) {

			User sender = userService.getOne(sender_id);
			User receiver = userService.getOne(receiver_id);

			if(sender != null && receiver != null) {
				friendshipService.deleteFriend(sender, receiver);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return null;
			}			
		}
		
		@RequestMapping(value="/{id}/suggested",method = RequestMethod.GET)
		public ResponseEntity<List<UserDTO>> getSuggested(@PathVariable Long id) {
			User user = userService.getOne(id); 
			System.out.println("DIMSIMDISMIS");
			if(user != null) {
				List<User> listaSuggested = friendshipService.getSuggested(user);
				List<UserDTO> lista = new ArrayList<UserDTO>();
				for(User u : listaSuggested) {
					lista.add(new UserDTO(u));
				}
				return new ResponseEntity<>(lista, HttpStatus.OK);
			} else {
				return null;
			}
				
		}
		
		/*@RequestMapping(value="/delete/{receiver_id}/{sender_id}",method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteSuggested(@PathVariable Long receiver_id,
				@PathVariable Long sender_id) {

			User sender = userService.getOne(sender_id);
			User receiver = userService.getOne(receiver_id);

			if(sender != null && receiver != null) {
				friendshipService.deleteSuggested(sender, receiver);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return null;
			}			
		}*/
		
	
}
