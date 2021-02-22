package com.cine.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Realiza un mapeo de objecto con el bean modelMapper
	 * 
	 * @param <T>   Entidad a mapear
	 * @param Class Clase de salida
	 * 
	 * @return map
	 */
	public <D, T> D map(final T entity, Class<D> outClass) {
		return modelMapper.map(entity, outClass);
	}

	/**
	 * Metodo encargado de mapear una lista de objetos a otra
	 * 
	 * @param <T>   lista de objetos
	 * @param Class Clase de salida
	 * 
	 * @return lista
	 */
	public <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
	}
}
