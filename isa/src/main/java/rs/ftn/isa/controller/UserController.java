package rs.ftn.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.isa.dto.UserDTO;
import rs.ftn.isa.model.User;
import rs.ftn.isa.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/test")
	public String test() {
		return "testic";
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
		User user = userService.getOne(id);
		if(user != null) {
			UserDTO userDTO = new UserDTO(user);
			return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<UserDTO>> getAll() {
		List<User> users = userService.getAll();
		if(users != null) {
			List<UserDTO> usersDTO = new ArrayList<UserDTO>();
			for(User u : users) {
				usersDTO.add(new UserDTO(u));
			}
			return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<UserDTO> update(@RequestBody User user, @PathVariable Long id){
		User oldUser = userService.getOne(id);
		if(oldUser != null) {
			User newUser = userService.update(oldUser, user);
			return new ResponseEntity<UserDTO>(new UserDTO(newUser), HttpStatus.OK);
		}else {
			return null;
		}
	}
	
}
