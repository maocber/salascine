package com.cine.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ciudad")

public class CiudadEntity {
	
	@Id
	@Column(name = "id")
	private long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "ciudad")
	private List<SucursalEntity> sucursales;

}
