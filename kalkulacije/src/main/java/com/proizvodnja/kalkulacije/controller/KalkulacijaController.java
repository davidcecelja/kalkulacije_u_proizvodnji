package com.proizvodnja.kalkulacije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proizvodnja.kalkulacije.model.Proizvod;
import com.proizvodnja.kalkulacije.service.ProizvodService;

@Controller
public class KalkulacijaController {
	
	@Autowired
	private ProizvodService service;

	@GetMapping("/kalkulacija")
    public String kalkulacijaPage(Model model) {
        try {        
            List<Proizvod> proizvodi = (List<Proizvod>)service.getAllProizvod();
            model.addAttribute("proizvodi", proizvodi);
            return "kalkulacija"; 
        } catch (Exception e) {     
            return "error"; 
        }
    }
}
