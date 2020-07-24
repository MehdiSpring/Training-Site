package com.springguru.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.models.Formation;
import com.springguru.repository.FormationRepository;
import com.springguru.services.FormationService;

@Profile("java")
@Service
public class FormationServiceImplDB implements FormationService {

	private final FormationRepository formationRepository;
	
	public FormationServiceImplDB(FormationRepository formationRepository) {
		this.formationRepository = formationRepository;
	}
	
	@Override
	public Set<Formation> findAll() {
		Set<Formation> formations = new HashSet<Formation>();
		this.formationRepository.findAll().iterator().forEachRemaining(formations::add);
		
		return formations;
	}

}
