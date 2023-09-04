package com.proizvodnja.kalkulacije.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean autentifikacijaUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registracijaUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void odjavaUser() {
		// TODO Auto-generated method stub
		
	}

}
