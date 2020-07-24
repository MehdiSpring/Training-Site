package com.springguru.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springguru.models.Formation;
import com.springguru.services.FormationService;

@Controller
public class FormationsController {
	
	private final FormationService formationService;

	public FormationsController(FormationService formationService) {
		this.formationService = formationService;
	}
	
	@RequestMapping("/formations")
	public String chargerLesFormations(Model model)
	{
		Set<Formation> formations = this.formationService.findAll();
		
		model.addAttribute("formations", formations);
		
		return "accueil";
	}
	

}
