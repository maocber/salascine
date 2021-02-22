package com.cine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sala")
public class SalaEntity {
	@Id
	private long id;
	
	private int filas;
	
	@Column(name="max_sillas_fila")
	private int maxSillasFila;
	
	@ManyToOne
	@JoinColumn(name="sucursal_id")
	private SucursalEntity sucursal;
	
	@ManyToOne
	@JoinColumn(name="tiposala_id")
	private TipoSalaEntity tipoSala;
}
