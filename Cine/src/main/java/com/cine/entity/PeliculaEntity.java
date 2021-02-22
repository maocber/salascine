package com.cine.entity;

import java.util.Date;
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
@Table(name="pelicula")

public class PeliculaEntity {
	
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name ="nombre_original")
	private String nombreOriginal;
	
	@Column(name ="nombre_traducido")
	private String nombreTraducido;
	
	private String imagen;
	
	@Column(name ="fecha_estreno")
	private Date fechaEstreno;
	
	
	@Column(name ="fecha_baja")
	private Date fechaBaja;
		
	private int duracion;
	
	@ManyToOne
	@JoinColumn(name ="formato")
	private TipoSalaEntity formato;
	
	@OneToMany(mappedBy = "pelicula")
	private List<DatosExtraEntity> datosExtra;
	
	@JoinTable(
	        name = "pelicula_sucursal",
	        joinColumns = @JoinColumn(name = "FK_Pelicula", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_Sucursal", nullable = false)
	)
	@ManyToMany(cascade = CascadeType.ALL)
    private List<SucursalEntity> sucursales;
	
	@JoinTable(
	        name = "pelicula_genero",
	        joinColumns = @JoinColumn(name = "FK_PeliculaGen", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_GeneroPel", nullable = false)
	)
	@ManyToMany(cascade = CascadeType.ALL)
    private List<GeneroEntity> generos;

}
