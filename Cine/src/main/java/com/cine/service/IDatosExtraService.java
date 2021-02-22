package com.cine.service;

import java.util.List;

import com.cine.dto.DatosExtraDTO;

public interface IDatosExtraService {
	public DatosExtraDTO guardarDatoExtra(DatosExtraDTO datoExtra);
	public List<DatosExtraDTO> verDatosExtraPelicula(int peliculaId);
}
