package com.proizvodnja.kalkulacije.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.model.Proizvod;

@Service
@Transactional
public class ProizvodServiceImpl implements ProizvodService{

	@Override
	public Proizvod createProizvod(Proizvod proizvod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proizvod updateProizvod(Proizvod proizvod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proizvod getProizvod(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProizvod(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Proizvod> getAllProizvod() {
		// TODO Auto-generated method stub
		return null;
	}

}
