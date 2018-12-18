package rs.ftn.isa.service;

import java.util.List;

import rs.ftn.isa.model.User;

public interface UserService {

	User getOne(Long id);
	List<User> getAll();
	User save(User user);
	
	User update(User oldUser, User newUser);
	
}
