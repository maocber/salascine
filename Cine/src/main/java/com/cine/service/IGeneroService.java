package com.cine.service;

import java.util.List;

import com.cine.dto.GeneroDTO;

public interface IGeneroService {
	public GeneroDTO adicionar(GeneroDTO genero);
	public List<GeneroDTO> verGeneros();
}
