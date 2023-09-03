package com.proizvodnja.kalkulacije.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "korisnici")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String email;
	
	@Column
	private String lozinka;
	
	@Column
	private String uloga;
	
	@Column
	private String status;
	
	private boolean enabled;
	
	public enum Uloga {
	    ADMIN,
	    USER,
	    SUPERVISOR
	}

	public enum StatusKorisnika {
	    AKTIVAN,
	    BRISAN
	}

	public User() {
		super();
	}

	public User(long id, String email, String lozinka, String uloga, String status, boolean enabled) {
		super();
		this.id = id;
		this.email = email;
		this.lozinka = lozinka;
		this.uloga = uloga;
		this.status = status;
		this.enabled = enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}

