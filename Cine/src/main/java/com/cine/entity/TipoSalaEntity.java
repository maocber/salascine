package com.cine.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tiposala")
public class TipoSalaEntity {
	@Id
	private long id;
	
	private String tipo;
	
	@OneToMany(mappedBy = "tipoSala")
	private List<SalaEntity> salas;

}
