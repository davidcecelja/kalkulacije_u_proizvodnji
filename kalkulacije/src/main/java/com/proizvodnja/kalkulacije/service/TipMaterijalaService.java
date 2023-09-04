package com.proizvodnja.kalkulacije.service;

import com.proizvodnja.kalkulacije.model.TipMaterijala;

public interface TipMaterijalaService {

	TipMaterijala createTipMaterijala(TipMaterijala tipMaterijala);

	TipMaterijala updateTipMaterijala(TipMaterijala tipMaterijala);
	
	TipMaterijala getTipMaterijala(long id);

	void deleteTipMaterijala(long id);
	
	Iterable<TipMaterijala> getAllTipMaterijala();
}
