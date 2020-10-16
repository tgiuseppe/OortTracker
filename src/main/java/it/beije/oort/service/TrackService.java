package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bean.Track;
import it.beije.oort.bean.User;
import it.beije.oort.repository.TrackRepository;

@Service
public class TrackService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TrackRepository trackRepository;
	
	// Retrievers
	public Track retrieve(Long id) {
		log.debug("Retrieving track with ID " + id);
		Optional<Track> track = trackRepository.findById(id);
		return track.isPresent() ? track.get() : null;
	}
	
	public List<Track> retrieveTracksOf(User user) {
		if (user == null) {
			throw new IllegalArgumentException("This user is null");
		}
		log.debug("Retrieving tracks of user with ID " + user.getId());
		
		return trackRepository.findByIdUser(user.getId());
	}
	
	// Inserters
	public void insert(Track track) {
		log.debug("Inserting " + track);
		if (track == null) {
			throw new IllegalArgumentException("This track is null");
		}
		
		// TODO Create throw for track with null fields where they can't be
		
		trackRepository.saveAndFlush(track);
	}
	
	// Modifiers
	public void modify(Long id, Track trackData) {
		log.debug(new StringBuilder().append("Modifying track with ID ").append(id).append(" as ").append(trackData).toString());
		if (trackData == null) {
			throw new IllegalArgumentException("This track is null");
		}
		
		// TODO Create throw for track with null fields where they can't be
		
		Track track = this.retrieve(id);
		
		if (track == null) {
			String errorMsg = new StringBuilder().append("Track with ID ").append(id).append(" not found").toString();
			log.error(errorMsg);
			throw new IllegalArgumentException(errorMsg);
		}
		
		BeanUtils.copyProperties(trackData, track, "id");
		trackRepository.saveAndFlush(track);
	}
}
