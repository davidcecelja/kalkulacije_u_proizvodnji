package com.proizvodnja.kalkulacije.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proizvodnja.kalkulacije.model.MjernaJedinica;

@Repository
public interface MjernaJedinicaRepository extends JpaRepository<MjernaJedinica, Long>{

}
