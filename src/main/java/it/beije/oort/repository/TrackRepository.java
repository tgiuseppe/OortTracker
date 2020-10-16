package it.beije.oort.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.bean.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
	
	List<Track> findByIdUser(Long idUser);
	
}
