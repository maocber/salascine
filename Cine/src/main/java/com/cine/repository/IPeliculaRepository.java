package com.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.entity.PeliculaEntity;

public interface IPeliculaRepository extends JpaRepository<PeliculaEntity, Long> {

}
