package rs.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

}
