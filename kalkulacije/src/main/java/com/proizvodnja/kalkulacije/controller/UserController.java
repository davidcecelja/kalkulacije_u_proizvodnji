package com.proizvodnja.kalkulacije.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proizvodnja.kalkulacije.model.User;
import com.proizvodnja.kalkulacije.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/pocetna-admin")
	public String pocetnaAdmin(Model model) {
		model.addAttribute("users", service.getAllUser());
		return "pocetna_admin";
	}
	
	@GetMapping("/pocetna-user")
	public String pocetnaUser(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String emailUser = auth.getName();
		User trenutniUser = service.findByEmail(emailUser);
		model.addAttribute("user", trenutniUser);
		return "pocetna_user";
	}
	
	@GetMapping("/pocetna-supervisor")
	public String pocetnaSupervisor(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String emailUser = auth.getName();
		User trenutniUser = service.findByEmail(emailUser);
		
		model.addAttribute("user", trenutniUser);
		return "pocetna_supervisor";
	}
	
	@GetMapping("/novi")
	public String newUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "pocetna_admin";
	}
	
	@PostMapping("/novi")
	public String dodajUser(@ModelAttribute("user") User user) {
		service.registracijaUser(user);
		return "redirect:/login/";
	}
	
	@GetMapping("/uredi-user/{id}")
	public ModelAndView urediUser(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("uredi_user");
		User user = service.getUser(id);
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping("/uredi-user")
	public String spremiUser(@ModelAttribute("user") User user) {
	    service.updateUser(user);
	    return "redirect:/pocetna-admin";
	}
	
	@GetMapping("/brisi-user/{id}")
	public String brisiUser(@PathVariable(name = "id") long id) {             
	    service.deleteUser(id);
	    return "redirect:/pocetna-admin";
	}
	
	@GetMapping("/registracija")
	public String prikaziFormuRegistracije(Model model) {
	    model.addAttribute("user", new User());
	    model.addAttribute("greska", null); 
	    return "registracija";
	}
	
	@PostMapping("/registracija")
	public String registracijaKorisnika(@Valid User user, BindingResult bindingResult, Model model) {
	    if (bindingResult.hasErrors()) {          
	        return "registracija";
	    }  
	    String email = user.getEmail();
	    if(!email.matches("^.*@(admin\\.com|user\\.com|supervisor\\.com)$")) {
	    	model.addAttribute("greska", "Krivo upisan email!");
	    	return "registracija";
	    }
	    service.registracijaUser(user);
	    return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String prikaziFormuPrijave() {
	    return "login";
	}
	
	@GetMapping("/odjava")
	public String odjaviUser() {
	    service.odjavaUser();
	    return "redirect:/login";
	}
}





