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

import com.proizvodnja.kalkulacije.model.TipMaterijala;
import com.proizvodnja.kalkulacije.service.TipMaterijalaService;

@Controller
public class TipMaterijalaController {

	@Autowired
	private TipMaterijalaService service;

	@GetMapping("/tip_materijala")
	public String viewHomePage(Model model) {
		ArrayList<TipMaterijala> tipoviMaterijala = (ArrayList<TipMaterijala>) service.getAllTipMaterijala();
		model.addAttribute("tipovi_materijala", tipoviMaterijala);
		return "tip_materijala";
	}
	
	@GetMapping("/uredi_tip_materijala/{id}")
	public ModelAndView urediTipMaterijala(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("uredi_tip_materijala");
		TipMaterijala tipMaterijala = service.getTipMaterijala(id);
		mav.addObject("tip_materijala", tipMaterijala);
		return mav;
	}
	
	@PostMapping("/uredi_tip_materijala")
	public String spremiTipMaterijala(@ModelAttribute("tip_materijala") TipMaterijala tipMaterijala) {
		service.updateTipMaterijala(tipMaterijala);
		return "redirect:/tip_materijala/";
	}
}

