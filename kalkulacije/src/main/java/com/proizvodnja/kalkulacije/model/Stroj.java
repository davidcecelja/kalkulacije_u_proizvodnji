package com.proizvodnja.kalkulacije.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "strojevi")
public class Stroj {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String sifraStroja;
	
	@Column
	private String opis;
	
	@Column
	private String valutaStroj;
	
	@Column
	private String valutaRadnik;
	
	@Column
	private long cijenaRadaStroja;
	
	@Column
	private long cijenaRadaRadnika;
	
	@ManyToOne
	@JoinColumn(name = "mjernaJedinicaId", referencedColumnName = "id")
	private MjernaJedinica mjernaJedinica;

	public Stroj() {
		super();
	}

	public Stroj(long id, String sifraStroja, String opis, String valutaStroj, String valutaRadnik,
			long cijenaRadaStroja, long cijenaRadaRadnika, MjernaJedinica mjernaJedinica) {
		super();
		this.id = id;
		this.sifraStroja = sifraStroja;
		this.opis = opis;
		this.valutaStroj = valutaStroj;
		this.valutaRadnik = valutaRadnik;
		this.cijenaRadaStroja = cijenaRadaStroja;
		this.cijenaRadaRadnika = cijenaRadaRadnika;
		this.mjernaJedinica = mjernaJedinica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSifraStroja() {
		return sifraStroja;
	}

	public void setSifraStroja(String sifraStroja) {
		this.sifraStroja = sifraStroja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getValutaStroj() {
		return valutaStroj;
	}

	public void setValutaStroj(String valutaStroj) {
		this.valutaStroj = valutaStroj;
	}

	public String getValutaRadnik() {
		return valutaRadnik;
	}

	public void setValutaRadnik(String valutaRadnik) {
		this.valutaRadnik = valutaRadnik;
	}

	public long getCijenaRadaStroja() {
		return cijenaRadaStroja;
	}

	public void setCijenaRadaStroja(long cijenaRadaStroja) {
		this.cijenaRadaStroja = cijenaRadaStroja;
	}

	public long getCijenaRadaRadnika() {
		return cijenaRadaRadnika;
	}

	public void setCijenaRadaRadnika(long cijenaRadaRadnika) {
		this.cijenaRadaRadnika = cijenaRadaRadnika;
	}

	public MjernaJedinica getMjernaJedinica() {
		return mjernaJedinica;
	}

	public void setMjernaJedinica(MjernaJedinica mjernaJedinica) {
		this.mjernaJedinica = mjernaJedinica;
	}
}

