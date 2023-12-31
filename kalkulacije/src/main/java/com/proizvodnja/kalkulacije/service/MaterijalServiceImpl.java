package com.proizvodnja.kalkulacije.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.exception.ResourceNotFoundException;
import com.proizvodnja.kalkulacije.model.Materijal;
import com.proizvodnja.kalkulacije.repository.MaterijalRepository;

@Service
@Transactional
public class MaterijalServiceImpl implements MaterijalService{

	@Autowired
	private MaterijalRepository materijalRepository;
	
	@Override
	public Materijal createMaterijal(Materijal materijal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materijal updateMaterijal(Materijal materijal) throws ResourceNotFoundException {
		
		Optional<Materijal> data = this.materijalRepository.findById(materijal.getId());
		if(data.isPresent()) {
			Materijal materijalUpdate = data.get();
			materijalUpdate.setJedinicnaCijena(materijal.getJedinicnaCijena());
			materijalUpdate.setKolicina(materijal.getKolicina());
			materijalRepository.save(materijalUpdate);
			return materijalUpdate;
		} else {
			throw new ResourceNotFoundException ("Ne postoje podaci za: " + materijal.getId());
		}
	}

	@Override
	public Materijal getMaterijal(long id) {
		if(id == 0) 
			return new Materijal();
		
		Optional<Materijal> data = this.materijalRepository.findById(id);
		if(data.isPresent()) {
			return data.get();
		} else {
			return new Materijal();
		}		
	}

	@Override
	public void deleteMaterijal(long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Iterable<Materijal> getAllMaterijal() {
		return this.materijalRepository.findAll();
	}

	@Override
	public List<Materijal> getMaterijaliPoProizvodu(long id) {
		
		return null;
	}

}

