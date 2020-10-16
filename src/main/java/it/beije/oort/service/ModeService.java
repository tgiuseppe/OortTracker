package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bean.Mode;
import it.beije.oort.repository.ModeRepository;

@Service
public class ModeService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ModeRepository modeRepository;
	
	public Mode retrieve(Long id) {
		log.debug("Retrieving mode with ID " + id);
		Optional<Mode> mode = modeRepository.findById(id);
		return mode.isPresent() ? mode.get() : null;
	}
	
	public Mode retrieve(String type) {
		log.debug("Retrieving mode " + type);
		Optional<Mode> mode = modeRepository.findByType(type);
		return mode.isPresent() ? mode.get() : null;
	}
	
	public List<Mode> retrieveAll() {
		log.debug("Retrieving all modes");
		List<Mode> listModes = modeRepository.findAll();
		return listModes;
	}
	
}
