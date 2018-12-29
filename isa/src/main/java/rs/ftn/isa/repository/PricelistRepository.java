package rs.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.Pricelist;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

}
