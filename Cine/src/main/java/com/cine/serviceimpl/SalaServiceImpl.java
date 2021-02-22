package com.cine.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.dto.SalaDTO;
import com.cine.entity.SalaEntity;
import com.cine.repository.ISalaRepository;
import com.cine.service.ISalaService;
import com.cine.util.Mensajes;
import com.cine.util.ModelMapperUtil;

@Service
public class SalaServiceImpl implements ISalaService {
	private static final Logger LOG = LoggerFactory.getLogger(SalaServiceImpl.class);
	
	@Autowired
	ISalaRepository salaRepository;
	
	@Autowired
	ModelMapperUtil mapper;

	@Override
	public SalaDTO crear(SalaDTO sala) {
		try {
			SalaEntity salaEntity = mapper.map(sala, SalaEntity.class);
			salaRepository.save(salaEntity);
		} catch (Exception e) {
			List<String> mensajes = new ArrayList<>();
			mensajes.add(e.getMessage());
			String error = Mensajes.generarMensaje(mensajes);
			LOG.error(error);
		}
		return sala;
	}

	@Override
	public List<SalaDTO> verSalasXSucursal(long sucursalId) {
		List<SalaDTO> lstSalasDTO = new ArrayList<>();
		try {
			List<SalaEntity> lstSalas = salaRepository.findAllSalasXSucursal(sucursalId);
			lstSalasDTO = mapper.mapAll(lstSalas, SalaDTO.class);
			return lstSalasDTO;
		} catch (Exception e) {
			List<String> mensajes = new ArrayList<>();
			mensajes.add(e.getMessage());
			String error = Mensajes.generarMensaje(mensajes);
			LOG.error(error);
		}
		return lstSalasDTO;
	}

}
