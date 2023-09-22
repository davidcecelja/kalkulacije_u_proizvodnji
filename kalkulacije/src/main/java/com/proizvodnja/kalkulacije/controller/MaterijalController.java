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

import com.proizvodnja.kalkulacije.model.Materijal;
import com.proizvodnja.kalkulacije.service.MaterijalService;

@Controller
public class MaterijalController {
	
	@Autowired
	private MaterijalService service;

	@GetMapping("/materijali")
	public String viewHomePage(Model model) {
		ArrayList<Materijal> materijali = (ArrayList<Materijal>) service.getAllMaterijal();
		model.addAttribute("materijali", materijali);
		return "materijali";
	}
	
	@GetMapping("/materijali/{id}")
	public String materijaliZaProizvod(@PathVariable("id") long id, Model model) {
		List<Materijal> materijali = service.getMaterijaliPoProizvodu(id);
		model.addAttribute("materijali", service.getMaterijaliPoProizvodu(id));
		return "materijali";
	}

	@GetMapping("/uredi_materijal/{id}")
	public ModelAndView urediMaterijal(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("uredi_materijal");
		Materijal materijal = service.getMaterijal(id);
		mav.addObject("materijal", materijal);
		return mav;
	}
	
	@PostMapping("/uredi_materijal")
	public String spremiMaterijal(@ModelAttribute("materijal") Materijal materijal) {
		service.updateMaterijal(materijal);
		return "redirect:/materijali/";
	}
}




