package com.cine.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mensajes {
	private final static Logger LOG = LoggerFactory.getLogger(Mensajes.class);	
	
	public static final String generarMensaje(List<String> mensajes) {
		StringBuilder mensaje = new StringBuilder();
		try {
			mensajes.stream().forEach(msg -> {
				mensaje.append(msg);
			});
			return mensaje.toString();
		} catch (Exception e) {
			LOG.error("Error al concatenar el mensaje {0}", e.getMessage());
		}
		return mensaje.toString();
	}

}
