package com.proizvodnja.kalkulacije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proizvodnja.kalkulacije.model.Materijal;
import com.proizvodnja.kalkulacije.model.Normativ;
import com.proizvodnja.kalkulacije.model.Proizvod;
import com.proizvodnja.kalkulacije.model.Stroj;
import com.proizvodnja.kalkulacije.repository.MaterijalRepository;
import com.proizvodnja.kalkulacije.repository.ProizvodRepository;
import com.proizvodnja.kalkulacije.repository.StrojRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class KalkulacijaServiceImpl implements KalkulacijaService{
	
	@Autowired
	private ProizvodRepository proizvodRepository;

	public double izracunajCijenuPoluproizvoda(long id, int kolicina) {
        Proizvod proizvod = proizvodRepository.findById(id).orElse(null);

        if (proizvod != null) {
            double ukupnaCijena = 0.0;

            // Pribavite normativ proizvoda koji sadrži potrebne materijale
            List<Normativ> materijali = proizvod.getMaterijali();

            if (!materijali.isEmpty()) {
                // Iterirajte kroz materijale u normativu i izračunajte njihove troškove
                for (Normativ normativ : materijali) {
                    Materijal materijal = normativ.getMaterijal();
                    double kolicina = normativ.getKolicina();
                    double jedinicnaCijena = materijal.getJedinicnaCijena();

                    // Izračunajte trošak materijala za svaki materijal u normativu
                    double cijenaMaterijala = jedinicnaCijena * kolicina * kolicina;
                    ukupnaCijena += cijenaMaterijala;
                }

                // Dodajte ostale troškove proizvoda prema potrebi
                // Na primjer, troškove rada stroja, troškove radnika, transport, itd.

                return ukupnaCijena;
            } else {
                throw new RuntimeException("Proizvod nema definiran normativ.");
            }
        } else {
            throw new EntityNotFoundException("Proizvod s ID-om " + id + " nije pronađen.");
        }
    }
}  

