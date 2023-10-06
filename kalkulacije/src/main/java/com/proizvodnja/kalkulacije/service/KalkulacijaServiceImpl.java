package com.proizvodnja.kalkulacije.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.model.Materijal;
import com.proizvodnja.kalkulacije.model.Normativ;
import com.proizvodnja.kalkulacije.model.Proizvod;

@Service
@Transactional
public class KalkulacijaServiceImpl implements KalkulacijaService{

	public double izracunajCijenuPoluproizvoda(Proizvod proizvod, double kolicina, double cijenaRadaStroja, double cijenaRadaRadnika) {
		
		double ukupnaCijena = 0.0;
		
		List<Normativ> normativi = proizvod.getMaterijali(); // ali koji materijali? oni koji imaju isti noramtiv kao i glavni proizvod i to String normativ;
		
		for(Normativ normativ : normativi) {
			Materijal materijal = normativ.getMaterijal();
			double kolicinaNormativa = normativ.getKolicina();
			double jedinicnaCijena = materijal.getJedinicnaCijena();
			
			double cijenaMaterijala = jedinicnaCijena * kolicinaNormativa * kolicina;
			
			ukupnaCijena += cijenaMaterijala;			
		}
		
		double trosakRadaStroja = cijenaRadaStroja * kolicina;
		double trosakRadaRadnika = cijenaRadaRadnika * kolicina;
		
		ukupnaCijena += trosakRadaStroja + trosakRadaRadnika;
		
		return ukupnaCijena;	
	} 
	
	public double izracunajCijenuProizvoda(Proizvod proizvod, double kolicina, double cijenaRadaStroja, double cijenaRadaRadnika) {
		
		double ukupnaCijena = 0.0;
		
		List<Normativ> normativi = proizvod.getMaterijali(); // ali koji materijali? oni koji imaju isti noramtiv kao i glavni proizvod i to String normativ;
		
		for(Normativ normativ : normativi) {
			Materijal materijal = normativ.getMaterijal();
			double kolicinaNormativa = normativ.getKolicina();
			double jedinicnaCijena = materijal.getJedinicnaCijena();
			
			double cijenaMaterijala = jedinicnaCijena * kolicinaNormativa * kolicina;
			
			ukupnaCijena += cijenaMaterijala;			
		}
		
		double trosakRadaStroja = cijenaRadaStroja * kolicina;
		double trosakRadaRadnika = cijenaRadaRadnika * kolicina;
		
		ukupnaCijena += trosakRadaStroja + trosakRadaRadnika;
		
		return ukupnaCijena;	
	}      
}  

