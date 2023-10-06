package com.proizvodnja.kalkulacije.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Normativ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
    @JoinColumn
	private Proizvod proizvod;
	
	@ManyToOne
    @JoinColumn
	private Materijal materijal;
	
	private double kolicina;
	
	@ManyToOne
	@JoinColumn(name = "mjernaJedinicaId", referencedColumnName = "id")
	private MjernaJedinica mjernaJedinica;

	public Normativ() {
		super();
	}

	public Normativ(long id, Proizvod proizvod, Materijal materijal, double kolicina, MjernaJedinica mjernaJedinica) {
		super();
		this.id = id;
		this.proizvod = proizvod;
		this.materijal = materijal;
		this.kolicina = kolicina;
		this.mjernaJedinica = mjernaJedinica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public MjernaJedinica getMjernaJedinica() {
		return mjernaJedinica;
	}

	public void setMjernaJedinica(MjernaJedinica mjernaJedinica) {
		this.mjernaJedinica = mjernaJedinica;
	}
}
