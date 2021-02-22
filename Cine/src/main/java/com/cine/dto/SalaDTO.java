package com.cine.dto;

import lombok.Data;

@Data
public class SalaDTO {

	private long id;
	
	private int filas;
	
	private int maxSillasFila;
	
	private SucursalDTO sucursal;
	
	private TipoSalaDTO tipoSala;
}
