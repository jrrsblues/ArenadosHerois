package com.arenaherois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arenaherois.model.Heroi;


public interface Herois  extends JpaRepository<Heroi, Long> {

}
