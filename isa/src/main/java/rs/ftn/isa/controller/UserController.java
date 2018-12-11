package rs.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAll();
		if(users != null) {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		return null;
	}
	
}
