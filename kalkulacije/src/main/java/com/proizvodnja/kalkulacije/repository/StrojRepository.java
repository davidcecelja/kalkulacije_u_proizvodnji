package com.proizvodnja.kalkulacije.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proizvodnja.kalkulacije.model.Stroj;

@Repository
public interface StrojRepository extends JpaRepository<Stroj, Long>{

}
