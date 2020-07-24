package com.springguru.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springguru.services.FormationService;

@ExtendWith(MockitoExtension.class)
class FormationsControllerTest {

	@Mock
	FormationService formationService;
	
	@InjectMocks
	FormationsController formationsController;
	
	MockMvc mockMVC;
	
	@BeforeEach
	void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);
		//this.formationsController = new FormationsController(formationService);
		mockMVC = MockMvcBuilders.standaloneSetup(formationsController).build();
	}

	@Test
	void testChargerLesFormations() {
		try {
			mockMVC.perform(get("/formations")).andExpect(status().isOk())
			                                   .andExpect(view().name("accueil"));
			verify(formationService,times(1)).findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		                                   
	}

}
