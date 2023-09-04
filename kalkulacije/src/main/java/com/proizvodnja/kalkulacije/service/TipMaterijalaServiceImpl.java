package com.proizvodnja.kalkulacije.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.model.TipMaterijala;
import com.proizvodnja.kalkulacije.repository.TipMaterijalaRepository;

@Service
@Transactional
public class TipMaterijalaServiceImpl implements TipMaterijalaService{

	@Autowired
	private TipMaterijalaRepository tipMaterijalaRepository;
	
	@Override
	public TipMaterijala createTipMaterijala(TipMaterijala tipMaterijala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipMaterijala updateTipMaterijala(TipMaterijala tipMaterijala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipMaterijala getTipMaterijala(long id) {
		if(id == 0) 
			return new TipMaterijala();
		
		Optional<TipMaterijala> data = this.tipMaterijalaRepository.findById(id);
		if(data.isPresent()) {
			return data.get();
		} else {
			return new TipMaterijala();
		}		
	}

	@Override
	public void deleteTipMaterijala(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<TipMaterijala> getAllTipMaterijala() {
		return this.tipMaterijalaRepository.findAll();
	}

}
