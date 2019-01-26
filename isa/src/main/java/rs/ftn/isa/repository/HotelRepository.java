package rs.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	Hotel findByName(String name);
	
	List<Hotel> findByAddressContaining(String address);
	

}
