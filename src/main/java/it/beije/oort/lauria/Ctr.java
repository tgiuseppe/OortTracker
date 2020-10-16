package it.beije.oort.lauria;

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
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		log.info("signIn get...");
		
		return "signIn";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		log.info("signUn get...");
		
		return "signUp";
	}
	@RequestMapping(value = "/prova", method = RequestMethod.GET)
	public String prova() {
		log.info("signUn get...");
		
		return "prova";
	}

}
