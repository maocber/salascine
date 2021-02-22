package com.cine.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cine.dto.GeneroDTO;
import com.cine.service.IGeneroService;

@Controller
@RequestMapping(value = "/apiCine/generos")
public class GeneroController {
	private static final  Logger LOG = LoggerFactory.getLogger(GeneroController.class);
	
	@Autowired
	IGeneroService generoService;
	
	@PostMapping("/crear")
	@ResponseBody
	public ResponseEntity<GeneroDTO> crearSala(@RequestBody GeneroDTO genero){
		LOG.info("SucursalController: inicio servicio de crear Sala, parametro | SalaDTO: {}", genero);
		try {
			generoService.adicionar(genero);
			return new ResponseEntity<>(genero, HttpStatus.OK);
		} catch (Exception ex) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", ex.getMessage(), ex.getStackTrace());
			return new ResponseEntity<>(genero, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/todos")
	@ResponseBody
	public ResponseEntity<List<GeneroDTO>> verListadoGeneros() {
		List<GeneroDTO> lstGeneros = new ArrayList<>();
		try {
			lstGeneros = generoService.verGeneros();
			return new ResponseEntity<>(lstGeneros, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(lstGeneros, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
