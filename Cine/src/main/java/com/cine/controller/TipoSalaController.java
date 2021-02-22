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

import com.cine.dto.TipoSalaDTO;
import com.cine.repository.ITipoSalaRepository;
import com.cine.service.ITipoSalaService;

@Controller
@RequestMapping(value= "/apiCine/tipoSala")
public class TipoSalaController {
	private static final  Logger LOG = LoggerFactory.getLogger(TipoSalaController.class);
	
	@Autowired
	ITipoSalaRepository tipoSalaRepository;
	
	@Autowired
	ITipoSalaService tipoSalaService;
	
	@PostMapping("/crear")
	@ResponseBody
	public ResponseEntity<TipoSalaDTO> crearSucursal(@RequestBody TipoSalaDTO tipoSala) {
		LOG.info("SucursalController: inicio servicio de crear TipoSala, parametro | TipoSalaDTO: {}", tipoSala);
		try {
			tipoSalaService.crearTipoSala(tipoSala);
			return new ResponseEntity<>(tipoSala, HttpStatus.OK);
		} catch (Exception ex) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", ex.getMessage(), ex.getStackTrace());
			return new ResponseEntity<>(tipoSala, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/todos")
	@ResponseBody
	public ResponseEntity<List<TipoSalaDTO>> verTiposSala(){
		List<TipoSalaDTO> lstTipoSala = new ArrayList<>();
		try {
			lstTipoSala = tipoSalaService.verTiposSala();
			return new ResponseEntity<>(lstTipoSala, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(lstTipoSala, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

}
