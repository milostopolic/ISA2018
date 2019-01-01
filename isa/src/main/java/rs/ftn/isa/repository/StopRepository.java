package rs.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {

}
