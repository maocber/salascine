package com.cine.service;

import java.util.List;

import com.cine.dto.DatosExtraDTO;
import com.cine.dto.PeliculaDTO;

public interface IPeliculaService {
	public PeliculaDTO crear(PeliculaDTO pelicula);
	public List<PeliculaDTO> verListadoPeliculas();
	public List<DatosExtraDTO> guardarDatosExtra(List<DatosExtraDTO> datosExtra);
}
