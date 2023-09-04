package com.proizvodnja.kalkulacije.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proizvodnja.kalkulacije.model.User;
import com.proizvodnja.kalkulacije.service.UserService;

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
}

@GetMapping("/novi")
public String noviKorisnikGet(Model model) {
    Korisnik korisnik = new Korisnik();
    model.addAttribute("korisnik", korisnik);
    return "pocetna_admin";
}

@PostMapping("/novi")
public String dodajKorisnikPost(@ModelAttribute("korisnik") Korisnik korisnik) {
    service.registracijaKorisnika(korisnik);
    return "redirect:/login/";
}

@GetMapping("/uredi_korisnik/{id}")
public ModelAndView urediKorisnikGet(@PathVariable("id") long id) {
    ModelAndView mav = new ModelAndView("uredi_korisnik");
    Korisnik korisnik = service.getKorisnik(id);
    mav.addObject("korisnik", korisnik);
    return mav;
}

@PostMapping("/uredi-korisnik")
public String spremiKorisnika(@ModelAttribute("korisnik") Korisnik korisnik) {
    service.updateKorisnik(korisnik);
    return "redirect:/pocetna-admin";
}

@GetMapping("/brisi_korisnik/{id}")
public String brisiKorisnik(@PathVariable(name = "id") long id) {             
    service.deleteKorisnik(id);
    return "redirect:/pocetna-admin";
}

@GetMapping("/registracija")
public String prikaziFormuRegistracije(Model model) {
    model.addAttribute("korisnik", new Korisnik());
    model.addAttribute("greska", null); 
    return "registracija";
}

@PostMapping("/registracija")
public String registracijaKorisnika(@Valid Korisnik korisnik, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {          
        return "registracija";
    }  
    String email = korisnik.getEmail();
    if(!email.matches("^.*@(mev\\.hr|student\\.mev\\.hr|admin\\.mev\\.hr)$")) {
    	model.addAttribute("greska", "Krivo upisan email!");
    	return "registracija";
    }
    service.registracijaKorisnika(korisnik);
    return "redirect:/login";
}

@GetMapping("/login")
public String prikaziFormuPrijave() {
    return "login";
}

@GetMapping("/odjava")
public String odjavaKorisnika() {
    service.odjavaKorisnika();
    return "redirect:/login";
}