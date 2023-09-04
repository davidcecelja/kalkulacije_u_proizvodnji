package com.proizvodnja.kalkulacije.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.model.MjernaJedinica;
import com.proizvodnja.kalkulacije.repository.MjernaJedinicaRepository;

@Service
@Transactional
public class MjernaJedinicaServiceImpl implements MjernaJedinicaService{

	@Autowired
	private MjernaJedinicaRepository mjernaJednicaRepository;
	
	@Override
	public MjernaJedinica createMjernaJedinica(MjernaJedinica mjernaJedinica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MjernaJedinica updateMjernaJedinica(MjernaJedinica mjernaJedinica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MjernaJedinica getMjernaJedinica(long id) {
		if(id == 0) 
			return new MjernaJedinica();
		
		Optional<MjernaJedinica> data = this.mjernaJednicaRepository.findById(id);
		if(data.isPresent()) {
			return data.get();
		} else {
			return new MjernaJedinica();
		}		
	}

	@Override
	public void deleteMjernaJedinica(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<MjernaJedinica> getAllMjernaJedinica() {
		return this.mjernaJednicaRepository.findAll();
	}

}
