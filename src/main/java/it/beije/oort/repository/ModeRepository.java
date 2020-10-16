package it.beije.oort.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.bean.Mode;

@Repository
public interface ModeRepository extends JpaRepository<Mode, Long> {
	
	Optional<Mode> findByType(String type);
	
}
