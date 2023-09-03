package com.proizvodnja.kalkulacije.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proizvodnja.kalkulacije.model.Proizvod;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, Long>{

}
