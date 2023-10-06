package com.proizvodnja.kalkulacije.service;

import com.proizvodnja.kalkulacije.model.Proizvod;

public interface KalkulacijaService {

	double izracunajCijenuPoluproizvoda(Proizvod proizvod, double kolicina, double cijenaRadaStroja, double cijenaRadaRadnika);
	
	double izracunajCijenuProizvoda(Proizvod proizvod, double kolicina, double cijenaRadaStroja, double cijenaRadaRadnika);
}
