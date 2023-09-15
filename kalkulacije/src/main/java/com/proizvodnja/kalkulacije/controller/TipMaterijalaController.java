package com.proizvodnja.kalkulacije.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proizvodnja.kalkulacije.model.TipMaterijala;
import com.proizvodnja.kalkulacije.service.TipMaterijalaService;

@Controller
public class TipMaterijalaController {

	@Autowired
	private TipMaterijalaService service;

	@GetMapping("/tip_materijala")
	public String viewHomePage(Model model) {
		ArrayList<TipMaterijala> popisTipovaMaterijala = (ArrayList<TipMaterijala>) service.getAllTipMaterijala();
		model.addAttribute("tip_materijala", popisTipovaMaterijala);
		return "tip_materijala";
	}
}
