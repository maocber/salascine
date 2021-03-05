package com.cine.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.constants.Constantes;
import com.cine.dto.SucursalDTO;
import com.cine.entity.SucursalEntity;
import com.cine.repository.ISucursalRepository;
import com.cine.service.ISucursalService;
import com.cine.util.Mensajes;
import com.cine.util.ModelMapperUtil;
import com.cine.dto.SalaDTO;

@Service
public class SucursalServiceImpl implements ISucursalService {
	private static final Logger LOG = LoggerFactory.getLogger(SucursalServiceImpl.class);
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	ModelMapperUtil mapper;

	@Override
	public SucursalDTO crearSucursal(SucursalDTO sucursal) {
		LOG.info(Constantes.INFO_CREAR_SUCURSAL);
		LOG.info(sucursal.getNombre());
		
		try {
			SucursalEntity sucursalModel = mapper.map(sucursal, SucursalEntity.class);
			sucursalModel = sucursalRepository.save(sucursalModel);
			sucursal.setId(sucursalModel.getId());
			return sucursal;
		} catch (Exception e) {
			List<String> mensajes = new ArrayList<>();
			mensajes.add(e.getMessage());
			String error = Mensajes.generarMensaje(mensajes);
			LOG.error(error);
		}
		return new SucursalDTO();
	}

	@Override
	public List<SucursalDTO> getSucursalesXCiudad(long ciudadId) {
		List<SucursalDTO> lstSucursalesDTO = new ArrayList<>();
		try {
			List<SucursalEntity> lstSucursales = sucursalRepository.findAllSucursalesXCiudad(ciudadId);
			lstSucursalesDTO = mapper.mapAll(lstSucursales, SucursalDTO.class);
			return lstSucursalesDTO;
		} catch (Exception e) {
			List<String> mensajes = new ArrayList<>();
			mensajes.add(e.getMessage());
			String error = Mensajes.generarMensaje(mensajes);
			LOG.error(error);
		}
		return lstSucursalesDTO;
	}

	@Override
	public List<SucursalDTO> crearSala(SalaDTO sala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalSucusales(long ciudad) {
		try {
			long total = sucursalRepository.count();
			return total;
		} catch (Exception e) {
			return -1;
		}
	}

}
