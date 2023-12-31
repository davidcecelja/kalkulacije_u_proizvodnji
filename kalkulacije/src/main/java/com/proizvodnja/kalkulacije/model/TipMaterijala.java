package com.proizvodnja.kalkulacije.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tip_materijala")
@Entity
public class TipMaterijala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String sifra;
	
	@Column
	private String opis;

	public TipMaterijala() {
		super();
	}

	public TipMaterijala(long id, String sifra, String opis) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.opis = opis;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return opis;
	}
	
	
}
