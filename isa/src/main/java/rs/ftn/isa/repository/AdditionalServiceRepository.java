package rs.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ftn.isa.model.AdditionalService;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Long> {

	List<AdditionalService> findByPricelist_Id(Long id);
	
}
