package com.proizvodnja.kalkulacije.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proizvodnja.kalkulacije.model.TipMaterijala;

@Repository
public interface TipMaterijalaRepository extends JpaRepository<TipMaterijala, Long>{

}
