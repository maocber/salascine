package com.cine.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cine.dto.CiudadDTO;
import com.cine.dto.SucursalDTO;
import com.cine.entity.SucursalEntity;
import com.cine.repository.ISucursalRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class SucursalRepositoryTest {
	
	@Mock 
	SucursalDTO sucursalDTO;
	
	@Mock 
	CiudadDTO ciudadDTO; 
	
	@Autowired
	TestEntityManager entityManager;

	@Autowired
    private ISucursalRepository sucursalRepository;
    
	
	@BeforeEach
	void setUp() throws Exception {
		sucursalDTO = new SucursalDTO();
		
		sucursalDTO = new SucursalDTO();
		sucursalDTO.setNombre("MiSucursal");
		sucursalDTO.setDireccion("Dir1");
		
		ciudadDTO = new CiudadDTO();
		ciudadDTO.setId(1);
		sucursalDTO.setCiudad(ciudadDTO);		
	}


	@Test
	void TestCrearSucursal() {
		// given
	    SucursalEntity sucursalE = new SucursalEntity();
	    sucursalE.setNombre("MiSucursal");
	    
	    entityManager.persist(sucursalE);
	    entityManager.flush();

	    // when
	    SucursalEntity sucursalFound = sucursalRepository.findByNombre(sucursalE.getNombre());

	    // then
	    assertEquals(sucursalFound,sucursalE);
	}

}
