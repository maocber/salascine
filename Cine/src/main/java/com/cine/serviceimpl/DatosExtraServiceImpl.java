package com.cine.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.dto.DatosExtraDTO;
import com.cine.entity.DatosExtraEntity;
import com.cine.repository.IDatosExtraRepository;
import com.cine.service.IDatosExtraService;
import com.cine.util.ModelMapperUtil;

@Service
public class DatosExtraServiceImpl implements IDatosExtraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(PeliculaServiceImpl.class);
	
	@Autowired
	IDatosExtraRepository datosExtraRepository;
	
	@Autowired
	ModelMapperUtil mapper;

	@Override
	public DatosExtraDTO guardarDatoExtra(DatosExtraDTO datoExtra) {
		try {
			DatosExtraEntity datoExtraEntity = mapper.map(datoExtra, DatosExtraEntity.class); 
			datosExtraRepository.save(datoExtraEntity);
		} catch (Exception e) {
			LOG.error("Error al guardar el dato extra {}", e.getMessage());
		}
		return datoExtra;
	}

	@Override
	public List<DatosExtraDTO> verDatosExtraPelicula(int peliculaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
