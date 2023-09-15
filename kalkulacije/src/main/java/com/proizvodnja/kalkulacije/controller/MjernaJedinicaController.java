package com.proizvodnja.kalkulacije.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
