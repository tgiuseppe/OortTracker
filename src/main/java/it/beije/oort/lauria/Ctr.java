package it.beije.oort.lauria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bean.User;
import it.beije.oort.service.UserService;

@Controller
public class Ctr {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home( HttpServletRequest request) {
		log.info("home get...");
		request.getSession().invalidate();
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
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(User newUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("signIn post...");
//		String nickname = request.getParameter("nickname");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
			
//		User user = new User(nickname, email, password);	
		userService.insert(newUser);
		log.debug("user:" +newUser);
		
		
		if(newUser != null) {
			//model.addAttribute("utente", utente);
			request.getSession().setAttribute("userBean", newUser);
			return "homeUser";
		}else {
			System.out.println("non c'è. utente: "+newUser);
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "signUp";
		}
		
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String signIn(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("signUn post...");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
//		Utente utente = JPADBtools.verifyUtenti(email, password);		
		User user = userService.retrieve(nickname, password);	
		log.debug("user:" +user);
		
		
		if(user != null) {
			//model.addAttribute("utente", utente);
			request.getSession().setAttribute("userBean", user);
			return "homeUser";
		}else {
			System.out.println("non c'è. utente: "+user);
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "signIn";
		}

	}

	@RequestMapping(value = "/homeUser", method = RequestMethod.GET)
	public String homeUser() {
		log.info("signUn get...");
		
		return "homeUser";
	}
	
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settings() {
		log.info("signUn get...");
		
		return "settings";
	}

	
	@RequestMapping(value = "/settings", method = RequestMethod.POST)
	public String settings(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("signUn post...");
		
		User user = (User) request.getSession().getAttribute("userBean");
		
		Long idUser = user.getId();
		
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		
		user.setNickname(nickname);
		user.setEmail(email);
		
		try {
			userService.modify(idUser, user);	
			model.addAttribute("checkNickAndMail", "Changes done!");
		}catch(IllegalArgumentException e) {
			model.addAttribute("errore", e.getMessage());
			return "settings";
		}
		
		return "settings";

	}

	@RequestMapping(value = "/modifyPsw", method = RequestMethod.GET)
	public String modifyPsw() {
		log.info("modifyPsw get...");
		
		return "modifyPsw";
	}

	@RequestMapping(value = "/modifyPsw", method = RequestMethod.POST)
	public String modifyPsw(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("modifyPsw post...");
		User user = (User) request.getSession().getAttribute("userBean");
		
		Long idUser = user.getId();
		
		String oldPassword = request.getParameter("password");
		String newPassword = request.getParameter("newpassword");
		
		try {
			if(userService.checkPassword(idUser, oldPassword)) {
				userService.modifyPassword(idUser, newPassword);
				model.addAttribute("checkPswOk", "Changes done!");
				return "modifyPsw";
			}else {
				model.addAttribute("checkPswKo", "you entered the wrong  old password!");
				return "modifyPsw";
			}
		}catch(IllegalArgumentException e) {
			model.addAttribute("errore", e.getMessage());
			return "modifyPsw";
		}

	}

	
	@RequestMapping(value = "/prova", method = RequestMethod.GET)
	public String prova() {
		log.info("signUn get...");
		
		return "prova";
	}

}
