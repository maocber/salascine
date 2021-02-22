package com.cine.service;

import java.util.List;

import com.cine.dto.SalaDTO;

public interface ISalaService {
	public SalaDTO crear(SalaDTO sala);
	public List<SalaDTO> verSalasXSucursal(long sucursalId);
	
}
