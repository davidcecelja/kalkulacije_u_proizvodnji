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
@Table(name = "materijali")
public class Materijal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String sifra;
	
	@Column
	private String opis;
	
	@Column
	private long jedinicnaCijena;
	
	@Column
	private String valuta;
	
	@Column
	private long kolicina;
	
	@ManyToOne
	@JoinColumn(name = "materijalTipId", referencedColumnName = "id")
	private TipMaterijala tipMaterijala;
	
	@ManyToOne
	@JoinColumn()
	private MjernaJedinica mjernaJedinica;
	
	public Materijal() {
		super();
	}

	public Materijal(long id, String sifra, String opis, long jedinicnaCijena, String valuta, long kolicina,
			TipMaterijala tipMaterijala, MjernaJedinica mjernaJedinica) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.opis = opis;
		this.jedinicnaCijena = jedinicnaCijena;
		this.valuta = valuta;
		this.kolicina = kolicina;
		this.tipMaterijala = tipMaterijala;
		this.mjernaJedinica = mjernaJedinica;
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

	public long getJedinicnaCijena() {
		return jedinicnaCijena;
	}

	public void setJedinicnaCijena(long jedinicnaCijena) {
		this.jedinicnaCijena = jedinicnaCijena;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public long getKolicina() {
		return kolicina;
	}

	public void setKolicina(long kolicina) {
		this.kolicina = kolicina;
	}

	public TipMaterijala getTipMaterijala() {
		return tipMaterijala;
	}

	public void setTipMaterijala(TipMaterijala tipMaterijala) {
		this.tipMaterijala = tipMaterijala;
	}

	public MjernaJedinica getMjernaJedinica() {
		return mjernaJedinica;
	}

	public void setMjernaJedinica(MjernaJedinica mjernaJedinica) {
		this.mjernaJedinica = mjernaJedinica;
	}
}



