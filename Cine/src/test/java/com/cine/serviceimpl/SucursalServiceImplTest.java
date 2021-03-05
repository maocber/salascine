//https://www.baeldung.com/spring-boot-testing

package com.cine.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cine.dto.SucursalDTO;
import com.cine.entity.CiudadEntity;
import com.cine.entity.SucursalEntity;
import com.cine.repository.ISucursalRepository;
import com.cine.service.ISucursalService;

@SpringBootTest
@RunWith(SpringRunner.class)
class SucursalServiceImplTest {
	
	@TestConfiguration
    class SucursalServiceImplTestContextConfiguration {
 
        @Bean
        public ISucursalService sucursalService() {
            return new SucursalServiceImpl();
        }
    }
	
	@Autowired
    private ISucursalService sucursalService;
	
	@MockBean
    private ISucursalRepository sucursalRepository;
	
	@Mock
	SucursalDTO sucursalDTOFound;
	
	@Mock
	CiudadEntity ciudad;

	@BeforeEach
	public void setUp() {
		List<SucursalEntity> lstSucursales = new ArrayList<>();
	    SucursalEntity sucursalE= new SucursalEntity();
	    sucursalE.setNombre("Sucursal 1");
	    
	    ciudad = new CiudadEntity();
	    ciudad.setId(1L);
	    ciudad.setNombre("bogota");
	    
	    sucursalE.setCiudad(ciudad);
	    
	    lstSucursales.add(sucursalE);

	    Mockito.when(sucursalRepository.findAllSucursalesXCiudad(ciudad.getId()))
	      .thenReturn(lstSucursales);
	}

	@Test
	void validarLaCiudadDeLaSucursal() {
	    int ciudadId = 1;
	    String nombreCiudad = "bogota";
	    List<SucursalDTO> lstSucursalesFound = sucursalService.getSucursalesXCiudad(ciudadId);
	    sucursalDTOFound =  lstSucursalesFound.get(0);
	 
	    assertThat(sucursalDTOFound.getCiudad().getNombre()).isEqualTo(nombreCiudad);

	 }

}
