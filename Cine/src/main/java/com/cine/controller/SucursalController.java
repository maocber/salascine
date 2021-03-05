package com.cine.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cine.dto.SucursalDTO;
import com.cine.service.ISucursalService;

@RestController
@RequestMapping(value = "/apiCine/sucursales")
public class SucursalController {
	private static final  Logger LOG = LoggerFactory.getLogger(SucursalController.class);

	@Autowired
	private ISucursalService sucursalesService;
	
	@PostMapping("/crear")
	@ResponseBody
	public ResponseEntity<SucursalDTO> crearSucursal(@RequestBody SucursalDTO sucursal) {
		LOG.info("SucursalController: inicio servicio de crear sucursal, parametro | sucursalDTO: {}", sucursal);
		try {
			sucursal = sucursalesService.crearSucursal(sucursal);
			return new ResponseEntity<>(sucursal, HttpStatus.OK);
		} catch (Exception ex) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", ex.getMessage(), ex.getStackTrace());
			return new ResponseEntity<>(sucursal, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/sucursalesxciudad")
	@ResponseBody
	public ResponseEntity<List<SucursalDTO>> verSucursalesXCiudad(Long ciudadId) {
		List<SucursalDTO> lstSucursales = new ArrayList<>();
		try {
			lstSucursales = sucursalesService.getSucursalesXCiudad(ciudadId);
			return new ResponseEntity<>(lstSucursales, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Respuesta fallida al traer el registro, error: {} | {} ", e.getMessage(), e.getStackTrace());
			return new ResponseEntity<>(lstSucursales, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/totalSucursales")
	@ResponseBody
	public long getTotalSucursalesXCiudad(long ciudadId) {
		try {
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
}
