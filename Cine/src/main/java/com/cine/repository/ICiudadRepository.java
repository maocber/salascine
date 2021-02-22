package com.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.entity.CiudadEntity;

public interface ICiudadRepository extends JpaRepository<CiudadEntity, Long>{

}
