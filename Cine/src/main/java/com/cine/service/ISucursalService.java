package com.cine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cine.dto.SalaDTO;
import com.cine.dto.SucursalDTO;

@Service
public interface ISucursalService {
	
	public SucursalDTO crearSucursal(SucursalDTO sucursal);
	public List<SucursalDTO> getSucursalesXCiudad(long ciudadId);
	public List<SucursalDTO> crearSala(SalaDTO sala);
	public long getTotalSucusales(long ciudad);
	
}
