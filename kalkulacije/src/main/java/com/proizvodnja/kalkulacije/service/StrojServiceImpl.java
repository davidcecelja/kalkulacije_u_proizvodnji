package com.proizvodnja.kalkulacije.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.exception.ResourceNotFoundException;
import com.proizvodnja.kalkulacije.model.Stroj;
import com.proizvodnja.kalkulacije.repository.StrojRepository;

@Service
@Transactional
public class StrojServiceImpl implements StrojService{

	@Autowired
	private StrojRepository strojRepository;
	
	@Override
	public Stroj createStroj(Stroj stroj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stroj updateStroj(Stroj stroj) throws ResourceNotFoundException {
		
		Optional<Stroj> data = strojRepository.findById(stroj.getId());
		if(data.isPresent()) {
			Stroj strojUpdate = data.get();
			strojUpdate.setCijenaRadaStroja(stroj.getCijenaRadaStroja());
			strojUpdate.setCijenaRadaRadnika(stroj.getCijenaRadaRadnika());
			strojRepository.save(strojUpdate);
			return strojUpdate;
		} else {
			throw new ResourceNotFoundException("Ne postoje podaci za: " + stroj.getId());
		}	
	}

	@Override
	public Stroj getStroj(long id) {
		if(id == 0) 
			return new Stroj();
		
		Optional<Stroj> data = this.strojRepository.findById(id);
		if(data.isPresent()) {
			return data.get();
		} else {
			return new Stroj();
		}		
	}

	@Override
	public void deleteStroj(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Stroj> getAllStroj() {
		return this.strojRepository.findAll();
	}

}
