package com.cine.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.constants.Constantes;
import com.cine.dto.TipoSalaDTO;
import com.cine.entity.TipoSalaEntity;
import com.cine.repository.ITipoSalaRepository;
import com.cine.service.ITipoSalaService;
import com.cine.util.Mensajes;
import com.cine.util.ModelMapperUtil;

@Service
public class TipoSalaServiceImpl implements ITipoSalaService {
	private static final Logger LOG = LoggerFactory.getLogger(TipoSalaServiceImpl.class);
	
	@Autowired
	ITipoSalaRepository tipoSalaRepository;
	
	@Autowired
	ModelMapperUtil mapper;

	@Override
	public TipoSalaDTO crearTipoSala(TipoSalaDTO tipoSala) {
		LOG.info(Constantes.INFO_CREAR_SUCURSAL);
		LOG.info(tipoSala.getTipo());
		
		try {
			TipoSalaEntity tipoSalaModel = mapper.map(tipoSala, TipoSalaEntity.class);
			tipoSalaRepository.save(tipoSalaModel);
			return tipoSala;
		} catch (Exception e) {
			List<String> mensajes = new ArrayList<>();
			mensajes.add(e.getMessage());
			String error = Mensajes.generarMensaje(mensajes);
			LOG.error(error);
		}
		return new TipoSalaDTO();
	}

	@Override
	public List<TipoSalaDTO> verTiposSala() {
		List<TipoSalaDTO> lstTipoSalsaDTO = new ArrayList<>();
		try {
			List<TipoSalaEntity> lstTiposSala = tipoSalaRepository.findAll();
			lstTipoSalsaDTO = mapper.mapAll(lstTiposSala, TipoSalaDTO.class);
			return lstTipoSalsaDTO;
		} catch (Exception e) {
			List<String> mensajes = new ArrayList<>();
			mensajes.add(e.getMessage());
			String error = Mensajes.generarMensaje(mensajes);
			LOG.error(error);
		}
		return null;
	}

}
