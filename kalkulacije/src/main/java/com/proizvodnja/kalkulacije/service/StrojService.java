package com.proizvodnja.kalkulacije.service;

import java.util.List;

import com.proizvodnja.kalkulacije.model.Stroj;

public interface StrojService {

	Stroj createStroj(Stroj stroj);

	Stroj updateStroj(Stroj stroj);
	
	Stroj getStroj(long id);

	void deleteStroj(long id);
	
	Iterable<Stroj> getAllStroj();

	List<Stroj> getStrojeviPoProizvodu(long id);
}
