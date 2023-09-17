package com.proizvodnja.kalkulacije.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proizvodnja.kalkulacije.model.Proizvod;
import com.proizvodnja.kalkulacije.service.ProizvodService;

@Controller
public class ProizvodController {

	@Autowired
	private ProizvodService service;

	@GetMapping("/proizvodi")
	public String viewHomePage(Model model) {
		ArrayList<Proizvod> popisProizvoda = (ArrayList<Proizvod>) service.getAllProizvod();
		model.addAttribute("proizvodi", popisProizvoda);
		return "proizvodi";
	}
	
	@GetMapping("/uredi_proizvod/{id}")
	public ModelAndView urediProizvod(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("uredi_proizvod");
		Proizvod proizvod = service.getProizvod(id);
		mav.addObject("proizvod", proizvod);
		return mav;
	}
	
	@PostMapping("/uredi_proizvod")
	public String spremiProizvod(@ModelAttribute("proizvod") Proizvod proizvod) {
		service.updateProizvod(proizvod);
		return "redirect:/proizvodi/";
	}
}
