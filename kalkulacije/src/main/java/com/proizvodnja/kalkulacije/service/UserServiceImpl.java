package com.proizvodnja.kalkulacije.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.exception.ResourceNotFoundException;
import com.proizvodnja.kalkulacije.model.User;
import com.proizvodnja.kalkulacije.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User updateUser(User user) throws ResourceNotFoundException {
		Optional<User> data = this.repository.findById(user.getId());
		if(data.isPresent()) {
			User userUpdate = data.get();
			userUpdate.setEmail(user.getEmail());
			userUpdate.setLozinka(passwordEncoder.encode(user.getLozinka()));
			userUpdate.setUloga(user.getUloga());	
			repository.save(userUpdate);
			return userUpdate;
		} else {
			throw new ResourceNotFoundException("Zapis nije pronađen : " + user.getId());
		}		
	}

	@Override
	public User getUser(long id) {
		if(id == 0) {
			return new User();
		}
		Optional<User> data = this.repository.findById(id);
		if(data.isPresent()) {
			return data.get();
		} else {
			return new User();
		}
	}

	@Override
	public void deleteUser(long id) {
		Optional<User> data = repository.findById(id);
        if (data.isPresent()) {
        	User user = data.get();
            user.setStatus("BRISAN");
            repository.save(user);
        } else {
            throw new ResourceNotFoundException("Korisnik nije pronađen.");
        }
	}

	@Override
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public boolean autentifikacijaUser(User user) {
		User spremljeniUser = repository.findByEmail(user.getEmail());
		if (spremljeniUser != null) {
			return user.getLozinka().equals(spremljeniUser.getLozinka());
		}
		return false;
	}

	@Override
	public void registracijaUser(User user) {
		user.setEnabled(true);
		user.setLozinka(passwordEncoder.encode(user.getLozinka()));
		String email = user.getEmail();
		String uloga;
		if (email.endsWith("@admin.com")) {
            uloga = "ADMIN";
        } else if (email.endsWith("@user.com")) {
            uloga = "USER";
        } else if(email.endsWith("@supervisor.com")) {
        	uloga = "SUPERVISOR";
        }
       else {
            throw new IllegalStateException("Nepoznata uloga korisnika");
        }
		user.setUloga(uloga);
		user.setStatus("AKTIVAN");
	    repository.save(user);		
	}

	@Override
	public void odjavaUser() {
		SecurityContextHolder.clearContext();	
	}

	@Override
	public Iterable<User> getAllUser() {
		return this.repository.findAll();
	}
}
