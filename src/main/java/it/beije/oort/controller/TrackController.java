package it.beije.oort.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bean.Mode;
import it.beije.oort.bean.Track;
import it.beije.oort.bean.User;
import it.beije.oort.repository.TrackRepository;
import it.beije.oort.service.ModeService;
import it.beije.oort.service.TrackService;
import it.beije.oort.service.UserService;

@Controller
public class TrackController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ModeService modeService;
	
	@Autowired
	private TrackService trackService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/tracks", method = RequestMethod.GET)
	public String tracks(Model model) {
		String page = "/userTracks";
		User user = userService.retrieve(1L);
		
		List<Track> trackList = trackService.retrieveTracksOf(user);
		List<Mode> modeList = modeService.retrieveAll();
		Map<Long, Mode> modeMap = new HashMap<Long, Mode>();
		
		for(Mode mode : modeList) {
			if(! modeMap.containsKey(mode.getId())) {
				modeMap.put(mode.getId(), mode);
			}
		}
		
		model.addAttribute("trackList", trackList);
		model.addAttribute("modeMap", modeMap);
		
		return page;
	}
	
	@RequestMapping(value = "/addtrack", method = RequestMethod.GET)
	public String addTrackGet(Model model) {
		String page = "/insTrack";
		List<Mode> modeList = modeService.retrieveAll();
		
		model.addAttribute("modeList", modeList);
		return page;
	}
	
	@RequestMapping(value = "/addtrack", method = RequestMethod.POST)
	public String addTrackPost(HttpServletRequest request, Model model) {
		String page = "/insTrack";
		Timestamp startDatetime = null;
		Timestamp endDatetime = null;
		try {
			startDatetime = request.getParameter("startDatetime") == null ? null :
				new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("startDatetime")).getTime());
			endDatetime = request.getParameter("endDatetime") == null ? null :
				new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("endDatetime")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Mode> modeList = modeService.retrieveAll();
		Track track = new Track();
		
		track.setIdUser(((User)request.getSession().getAttribute("userBean")).getId());
		track.setIdMode(Long.parseLong(request.getParameter("idMode")));
		track.setStartAddress(request.getParameter("startAddress"));
		track.setEndAddress(request.getParameter("endAddress"));
		track.setStartDatetime(startDatetime);
		track.setEndDatetime(endDatetime);
		log.debug(track.toString());
		
		trackService.insert(track);
		model.addAttribute("modeList", modeList);
		return page;
	}
	
}
