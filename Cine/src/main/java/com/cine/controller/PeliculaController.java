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

import com.cine.dto.DatosExtraDTO;
import com.cine.dto.PeliculaDTO;
import com.cine.service.IPeliculaService;

@Controller
@RequestMapping(value = "/apiCine/peliculas")
public class PeliculaController {
	private static final  Logger LOG = LoggerFactory.getLogger(PeliculaController.class);
	
	@Autowired
	IPeliculaService peliculaService;
	
	@PostMapping("/crear")
	@ResponseBody
	public ResponseEntity<PeliculaDTO> crearPelicula(@RequestBody PeliculaDTO pelicula){
		LOG.info("SucursalController: inicio servicio de crear Sala, parametro | SalaDTO: {}", pelicula);
		try {
			peliculaService.crear(pelicula);
			return new ResponseEntity<>(pelicula, HttpStatus.OK);
		} catch (Exception ex) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", ex.getMessage(), ex.getStackTrace());
			return new ResponseEntity<>(pelicula, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/todas")
	@ResponseBody
	public ResponseEntity<List<PeliculaDTO>> verListadoPeliculas() {
		List<PeliculaDTO> lstPeliculas = new ArrayList<>();
		try {
			lstPeliculas = peliculaService.verListadoPeliculas();
			return new ResponseEntity<>(lstPeliculas, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(lstPeliculas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/adicionardatos")
	@ResponseBody
	public ResponseEntity<List<DatosExtraDTO>> guardarDatosExternos(@RequestBody List<DatosExtraDTO> datosExtra){
		List<DatosExtraDTO> lstDatosExtra = new ArrayList<>();
		try {
			lstDatosExtra = peliculaService.guardarDatosExtra(datosExtra);
			return new ResponseEntity<>(lstDatosExtra, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(lstDatosExtra, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
