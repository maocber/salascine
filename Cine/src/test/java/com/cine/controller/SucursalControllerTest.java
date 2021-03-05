package com.cine.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.cine.dto.CiudadDTO;
import com.cine.dto.SucursalDTO;
import com.cine.service.ISucursalService;

@RunWith(SpringRunner.class)
@WebMvcTest(SucursalController.class)
class SucursalControllerTest {
	
	@Autowired
    private MockMvc mvc;

    @MockBean
    private ISucursalService sucursalService;
    
    @BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void givenVerSucursales_X_Ciudad_JsonFormat_Test()
	  throws Exception {
	    
	    SucursalDTO sucursalDTO = new SucursalDTO();
	    sucursalDTO.setId(1);
	    sucursalDTO.setNombre("Sucursal de Testing");
	    
	    CiudadDTO ciudadDTO = new CiudadDTO();
	    ciudadDTO.setId(5);
	    ciudadDTO.setNombre("ManizalesTest");
	    
	    sucursalDTO.setCiudad(ciudadDTO);
	    
	    List<SucursalDTO> lstSucursalesDTOXCiudad = Arrays.asList(sucursalDTO);
	    
	    Long ciudadId = 5L; 
	    
	    Mockito.when(sucursalService.getSucursalesXCiudad(ciudadId)).thenReturn(lstSucursalesDTOXCiudad);

	    mvc.perform(get("/apiCine/sucursales/sucursalesxciudad?ciudadId=5"))
		    .andExpect(status().isOk())
		    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		    .andExpect(jsonPath("$[0].nombre").value("Sucursal de Testing"));
	}

}
