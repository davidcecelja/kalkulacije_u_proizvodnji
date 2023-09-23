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

import com.proizvodnja.kalkulacije.model.Materijal;
import com.proizvodnja.kalkulacije.model.MjernaJedinica;
import com.proizvodnja.kalkulacije.service.MjernaJedinicaService;

@Controller
public class MjernaJedinicaController {

	@Autowired
	private MjernaJedinicaService service;

	@GetMapping("/mjerne_jedinice")
	public String viewHomePage(Model model) {
		ArrayList<MjernaJedinica> popisMjernihJedinica = (ArrayList<MjernaJedinica>) service.getAllMjernaJedinica();
		model.addAttribute("mjerne_jedinice", popisMjernihJedinica);
		return "mjerne_jedinice";
	}
	
	@GetMapping("/uredi_mjerna_jedinica/{id}")
	public ModelAndView urediMjernaJedinica(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("uredi_mjerna_jedinica");
		MjernaJedinica mjernaJedinica = service.getMjernaJedinica(id);
		mav.addObject("mjerna_jedinica", mjernaJedinica);
		return mav;
	}
	
	@PostMapping("/uredi_mjerna_jedinica")
	public String spremiMjernaJedinica(@ModelAttribute("mjerna_jedinica") MjernaJedinica mjernaJedinica) {
		service.updateMjernaJedinica(mjernaJedinica);
		return "redirect:/mjerne_jedinice/";
	}
}
