package com.cine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cine.entity.SucursalEntity;

public interface ISucursalRepository extends JpaRepository<SucursalEntity, Long>{

	@Query(value = "select s.* from sucursal s where ciudad_id = ?", nativeQuery = true)
	public List<SucursalEntity> findAllSucursalesXCiudad(@Param("ciudad_id") Long id);
}
