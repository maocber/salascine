package com.cine.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PeliculaDTO {
	private long id;
	private String nombreOriginal;
	private String nombreTraducido;
	private String imagen;
	private Date fechaEstreno;
	private Date fechaBaja;
	private int duracion;
	private TipoSalaDTO formato;
	private List<DatosExtraDTO> datosExtra;
	private List<GeneroDTO> generos;
}
