package com.cine.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.dto.GeneroDTO;
import com.cine.entity.GeneroEntity;
import com.cine.repository.IGeneroRepository;
import com.cine.service.IGeneroService;
import com.cine.util.ModelMapperUtil;

@Service
public class GeneroServiceImpl implements IGeneroService {
	
	private static final Logger LOG = LoggerFactory.getLogger(GeneroServiceImpl.class);
	
	@Autowired
	IGeneroRepository generoRepository;
	
	@Autowired
	ModelMapperUtil mapper;

	@Override
	public GeneroDTO adicionar(GeneroDTO genero) {
		try {
			GeneroEntity generoEntity = mapper.map(genero, GeneroEntity.class);
			generoRepository.save(generoEntity);
		} catch (Exception e) {
			LOG.error("Error al guardar el genero {}", e.getMessage());
		}
		
		return genero;
	}

	@Override
	public List<GeneroDTO> verGeneros() {
		List<GeneroDTO> lstGeneros = new ArrayList<>();
		try {
			List<GeneroEntity> lstGenerosEntity = generoRepository.findAll();
			lstGeneros = mapper.mapAll(lstGenerosEntity, GeneroDTO.class);
		} catch (Exception e) {
			LOG.error("Error al consultar el listado de generos: {}", e.getMessage());
		}
		return lstGeneros;
	}

}
