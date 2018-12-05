package rs.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ftn.isa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
