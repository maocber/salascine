package com.cine.service;

import java.util.List;

import com.cine.dto.TipoSalaDTO;

public interface ITipoSalaService{
	
	public TipoSalaDTO crearTipoSala(TipoSalaDTO tipoSalaDTO);
	public List<TipoSalaDTO> verTiposSala();

}
