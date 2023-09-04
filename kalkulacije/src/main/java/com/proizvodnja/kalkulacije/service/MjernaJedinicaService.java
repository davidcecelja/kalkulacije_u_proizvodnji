package com.proizvodnja.kalkulacije.service;

import com.proizvodnja.kalkulacije.model.MjernaJedinica;

public interface MjernaJedinicaService {

	MjernaJedinica createMjernaJedinica(MjernaJedinica mjernaJedinica);

	MjernaJedinica updateMjernaJedinica(MjernaJedinica mjernaJedinica);
	
	MjernaJedinica getMjernaJedinica(long id);

	void deleteMjernaJedinica(long id);
	
	Iterable<MjernaJedinica> getAllMjernaJedinica();
}
