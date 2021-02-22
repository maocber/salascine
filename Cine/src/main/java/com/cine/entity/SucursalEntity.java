package com.cine.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sucursal")
public class SucursalEntity {
	@Id
	@Column(name="id")
	private long id;
	
	private String nombre;

	private String direccion;
	
	private String administrador;
	
	@ManyToOne
	@JoinColumn(name ="ciudad_id")
	private CiudadEntity ciudad;
	
	@OneToMany(mappedBy = "sucursal")
	private List<SalaEntity> salas;
	
	@ManyToMany(mappedBy = "sucursales")
    private List<PeliculaEntity> peliculas;	

}
