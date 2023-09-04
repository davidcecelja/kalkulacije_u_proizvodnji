package com.proizvodnja.kalkulacije.service;

import com.proizvodnja.kalkulacije.model.User;

public interface UserService {

	User updateUser(User user);
	
	User getUser(long id);

	void deleteUser(long id);
	
	User findByEmail(String email);

	boolean autentifikacijaUser(User user);

	void registracijaUser(User user);

	void odjavaUser();
	
	Iterable<User> getAllUser();
}
