package com.cine.dto;

import java.util.List;

import lombok.Data;

public @Data class SucursalDTO {
	private long id;
	
	private String nombre;
	
	private String direccion;
	
	private String administrador;
	
	private CiudadDTO ciudad;
	
	private List<PeliculaDTO> peliculas;
}
