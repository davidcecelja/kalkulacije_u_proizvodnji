package com.proizvodnja.kalkulacije.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proizvodnja.kalkulacije.model.Stroj;
import com.proizvodnja.kalkulacije.service.StrojService;

@Controller
public class StrojController {

	@Autowired
	private StrojService service;

	@GetMapping("/strojevi")
	public String viewHomePage(Model model) {
		ArrayList<Stroj> popisStrojeva = (ArrayList<Stroj>) service.getAllStroj();
		model.addAttribute("strojevi", popisStrojeva);
		return "strojevi";
	}
	
	@GetMapping("/strojevi/{id}")
	public String strojeviZaProizvod(@PathVariable("id") long id, Model model) {
		List<Stroj> strojevi = service.getStrojeviPoProizvodu(id);
		model.addAttribute("strojevi", service.getStrojeviPoProizvodu(id));
		return "strojevi";
	}

	@GetMapping("/uredi_stroj/{id}")
	public ModelAndView urediStroj(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("uredi_stroj");
		Stroj stroj = service.getStroj(id);
		mav.addObject("stroj", stroj);
		return mav;
	}
	
	@PostMapping("/uredi_stroj")
	public String spremiStroj(@ModelAttribute("stroj") Stroj stroj) {
		service.updateStroj(stroj);
		return "redirect:/strojevi/";
	}
}
