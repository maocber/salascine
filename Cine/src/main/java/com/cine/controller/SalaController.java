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

import com.cine.dto.SalaDTO;
import com.cine.service.ISalaService;

@Controller
@RequestMapping(value = "/apiCine/salas")
public class SalaController {
	private static final  Logger LOG = LoggerFactory.getLogger(SalaController.class);
	
	@Autowired
	ISalaService salaService;

	@PostMapping("/crear")
	@ResponseBody
	public ResponseEntity<SalaDTO> crearSala(@RequestBody SalaDTO sala){
		LOG.info("SucursalController: inicio servicio de crear Sala, parametro | SalaDTO: {}", sala);
		try {
			salaService.crear(sala);
			return new ResponseEntity<>(sala, HttpStatus.OK);
		} catch (Exception ex) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", ex.getMessage(), ex.getStackTrace());
			return new ResponseEntity<>(sala, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/salasXSucursal")
	@ResponseBody
	public ResponseEntity<List<SalaDTO>> verSucursalesXCiudad(long sucursalId) {
		List<SalaDTO> lstSalas = new ArrayList<>();
		try {
			lstSalas = salaService.verSalasXSucursal(sucursalId);
			return new ResponseEntity<>(lstSalas, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(lstSalas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
