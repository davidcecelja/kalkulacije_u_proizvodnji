package com.proizvodnja.kalkulacije.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proizvodnja.kalkulacije.model.Materijal;

@Repository
public interface MaterijalRepository extends JpaRepository<Materijal, Long>{

}
