package it.beihe.oort.lauria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ctr {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		log.info("home get...");
		
		return "home";
	}
	
	@RequestMapping(value = "/singIn", method = RequestMethod.GET)
	public String singIn() {
		log.info("singIn get...");
		
		return "singIn";
	}

	@RequestMapping(value = "/singUn", method = RequestMethod.GET)
	public String singUn() {
		log.info("singUn get...");
		
		return "singUn";
	}

}
