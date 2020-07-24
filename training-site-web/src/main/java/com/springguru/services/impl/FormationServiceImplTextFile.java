package com.springguru.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.models.Formation;
import com.springguru.services.FormationService;

@Profile("txt")
@Service
public class FormationServiceImplTextFile implements FormationService {

	@Value("${flux.formation.source}")
	private String formationsFilePath;
	
	@Override
	public Set<Formation> findAll() {
		Set<Formation> formations = new HashSet<Formation>();
		
		File file = new File(formationsFilePath);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String line = null;
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			while(line!=null)
			{
				
				String[] tab = line.split(",");
					
				Formation formation = new Formation().builder().titre(tab[0]).contenu(tab[1]).build();
				formations.add(formation);
				line = bufferedReader.readLine();
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return formations;
	}

}
