package rs.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.User;
import rs.ftn.isa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}
	
	@Override
	public List<User> getAll(){
		return userRepository.findAll();		
	}

	
}
