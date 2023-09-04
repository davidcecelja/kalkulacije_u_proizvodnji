package com.proizvodnja.kalkulacije.service;

import com.proizvodnja.kalkulacije.model.Materijal;

public interface MaterijalService {

	Materijal createMaterijal(Materijal materijal);

	Materijal updateMaterijal(Materijal materijal);
	
	Materijal getMaterijal(long id);

	void deleteMaterijal(long id);
	
	Iterable<Materijal> getAllMaterijal();
}
