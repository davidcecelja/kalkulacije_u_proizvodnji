package com.proizvodnja.kalkulacije.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "proizvodi")
@Entity
public class Proizvod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String normativ;
	
	@Column
	private String sifra;
	
	@Column
	private String opis;
	
	@Column
	private Integer kolicina;
	
	@ManyToOne
	@JoinColumn()
	private MjernaJedinica mjernaJedinica;
	
	@ManyToOne
	@JoinColumn(name = "strojId", referencedColumnName = "id")
	private Stroj stroj;

	
	public Proizvod() {
		super();
	}

	public Proizvod(long id, String normativ, String sifra, String opis, Integer kolicina, MjernaJedinica mjernaJedinica,
			Stroj stroj) {
		super();
		this.id = id;
		this.normativ = normativ;
		this.sifra = sifra;
		this.opis = opis;
		this.kolicina = kolicina;
		this.mjernaJedinica = mjernaJedinica;
		this.stroj = stroj;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNormativ() {
		return normativ;
	}

	public void setNormativ(String normativ) {
		this.normativ = normativ;
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

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public MjernaJedinica getMjernaJedinica() {
		return mjernaJedinica;
	}

	public void setMjernaJedinica(MjernaJedinica mjernaJedinica) {
		this.mjernaJedinica = mjernaJedinica;
	}

	public Stroj getStroj() {
		return stroj;
	}

	public void setStroj(Stroj stroj) {
		this.stroj = stroj;
	}
}






