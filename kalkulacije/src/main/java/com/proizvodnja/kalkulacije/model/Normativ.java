package com.proizvodnja.kalkulacije.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Normativ {

	@ManyToOne
    @JoinColumn(name = "proizvod_id")
	private Proizvod proizvod;
	
	@ManyToOne
    @JoinColumn(name = "materijal_id")
	private Materijal materijal;
	
	private double kolicina;

	public Normativ() {
		super();
	}

	public Normativ(Proizvod proizvod, Materijal materijal, double kolicina) {
		super();
		this.proizvod = proizvod;
		this.materijal = materijal;
		this.kolicina = kolicina;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public Materijal getMaterijal() {
		return materijal;
	}

	public void setMaterijal(Materijal materijal) {
		this.materijal = materijal;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	
	
}
