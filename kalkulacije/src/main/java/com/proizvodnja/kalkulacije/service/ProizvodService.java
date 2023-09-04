package com.proizvodnja.kalkulacije.service;

import com.proizvodnja.kalkulacije.model.Proizvod;

public interface ProizvodService {

	Proizvod createProizvod(Proizvod proizvod);

	Proizvod updateProizvod(Proizvod proizvod);
	
	Proizvod getProizvod(long id);

	void deleteProizvod(long id);
	
	Iterable<Proizvod> getAllProizvod();
}
