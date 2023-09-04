package com.proizvodnja.kalkulacije.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.model.Proizvod;
import com.proizvodnja.kalkulacije.repository.ProizvodRepository;

@Service
@Transactional
public class ProizvodServiceImpl implements ProizvodService{

	@Autowired
	private ProizvodRepository proizvodRepository;
	
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
		if(id == 0) 
			return new Proizvod();
		
		Optional<Proizvod> data = this.proizvodRepository.findById(id);
		if(data.isPresent()) {
			return data.get();
		} else {
			return new Proizvod();
		}		
	}

	@Override
	public void deleteProizvod(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Proizvod> getAllProizvod() {
		return this.proizvodRepository.findAll();
	}

}
