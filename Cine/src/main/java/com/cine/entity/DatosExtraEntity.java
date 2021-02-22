package com.cine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="datos_extra")

public class DatosExtraEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	private String dato;
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="pelicula_id")
	private PeliculaEntity pelicula;	

}
