package com.cine.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.dto.DatosExtraDTO;
import com.cine.dto.PeliculaDTO;
import com.cine.entity.PeliculaEntity;
import com.cine.repository.IPeliculaRepository;
import com.cine.service.IDatosExtraService;
import com.cine.service.IPeliculaService;
import com.cine.util.Mensajes;
import com.cine.util.ModelMapperUtil;

@Service
public class PeliculaServiceImpl implements IPeliculaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(PeliculaServiceImpl.class);
	
	@Autowired
	IPeliculaRepository peliculaRepository;
	
	@Autowired
	IDatosExtraService datosExtraService;
	
	@Autowired
	ModelMapperUtil mapper;

	@Override
	public PeliculaDTO crear(PeliculaDTO pelicula) {
		try {
			PeliculaEntity peliculaEntity = mapper.map(pelicula, PeliculaEntity.class); 
			peliculaRepository.save(peliculaEntity);
		} catch (Exception e) {
			List<String> mensajes = new ArrayList<>();
			mensajes.add(e.getMessage());
			String error = Mensajes.generarMensaje(mensajes);
			LOG.error(error);
		}
		return pelicula;
	}

	@Override
	public List<PeliculaDTO> verListadoPeliculas() {
		List<PeliculaDTO> lstPeliculasDTO = new ArrayList<>();
		try {
			List<PeliculaEntity> lstPeliculas = peliculaRepository.findAll();
			lstPeliculasDTO = mapper.mapAll(lstPeliculas, PeliculaDTO.class);
			return lstPeliculasDTO;
		} catch (Exception e) {
			List<String> mensajes = new ArrayList<>();
			mensajes.add(e.getMessage());
			String error = Mensajes.generarMensaje(mensajes);
			LOG.error(error);
		}
		return lstPeliculasDTO;
	}

	@Override
	public List<DatosExtraDTO> guardarDatosExtra(List<DatosExtraDTO> datosExtra) {
		try {
			datosExtra.stream().forEach(dato -> datosExtraService.guardarDatoExtra(dato));
		} catch (Exception e) {
			LOG.error("Error al guardar dato extra de las peliculas: {} | Datos Extra: {}", e.getMessage(), datosExtra);
		}
		return datosExtra;
	}
	
	

}
