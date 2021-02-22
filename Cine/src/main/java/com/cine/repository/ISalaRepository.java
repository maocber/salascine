package com.cine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cine.entity.SalaEntity;

public interface ISalaRepository extends JpaRepository<SalaEntity, Long>{
	
	@Query(value = "select s.* from sala s where sucursal_id = ?", nativeQuery = true)
	public List<SalaEntity> findAllSalasXSucursal(@Param("sucursal_id") Long id);

}
