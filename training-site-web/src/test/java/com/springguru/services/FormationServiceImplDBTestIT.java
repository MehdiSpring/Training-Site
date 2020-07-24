package com.springguru.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springguru.models.Formation;
import com.springguru.repository.FormationRepository;
import com.springguru.services.impl.FormationServiceImplDB;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FormationServiceImplDBTestIT {

	@Autowired
	FormationRepository formationRepository;
	
	FormationServiceImplDB formationServiceImplDB;
	
	@BeforeEach
	void setUp() throws Exception {
		formationServiceImplDB = new FormationServiceImplDB(formationRepository);
	}

	@Test
	void testFindAll() {
		//this.formationRepository.save(new Formation().builder().titre("JAVA").build());
		//this.formationRepository.save(new Formation().builder().titre("Langage C").build());
		Set<Formation> formations = this.formationServiceImplDB.findAll();
		assertEquals(9, formations.size());
	}

}
