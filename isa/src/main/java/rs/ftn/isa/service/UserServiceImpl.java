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

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User update(User oldUser, User newUser) {
		// TODO Auto-generated method stub	
		if(newUser.getName() != null){
			oldUser.setName(newUser.getName());
		}
		if(newUser.getUsername() != null){
			oldUser.setUsername(newUser.getUsername());
		}
		if(newUser.getPhoneNmbr() != null){
			oldUser.setPhoneNmbr(newUser.getPhoneNmbr());
		}
		if(newUser.getSurname() != null){
			oldUser.setSurname(newUser.getSurname());
		}
		if(newUser.getAddress() != null){
			oldUser.setAddress(newUser.getAddress());
		}
		
		
		return userRepository.save(oldUser);
	}

	
}
