package com.springguru.bootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springguru.models.Categorie;
import com.springguru.models.Formation;
import com.springguru.models.Professeur;
import com.springguru.repository.CategorieRepository;
import com.springguru.repository.EtudiantRepository;
import com.springguru.repository.FormationRepository;
import com.springguru.repository.ProfesseurRepository;

@Component
public class LoadData implements CommandLineRunner {

	private final CategorieRepository categorieRepository;
	private final EtudiantRepository etudiantRepository;
	private final FormationRepository formationRepository;
	private final ProfesseurRepository professeurRepository;
	
	
	public LoadData(CategorieRepository categorieRepository, EtudiantRepository etudiantRepository,
			FormationRepository formationRepository, ProfesseurRepository professeurRepository) {
		
		this.categorieRepository = categorieRepository;
		this.etudiantRepository = etudiantRepository;
		this.formationRepository = formationRepository;
		this.professeurRepository = professeurRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Categorie informatique = this.categorieRepository.findByTitre("Informatique");
		
		//Les formations créé par le professeur John THOMPSON
		
		Professeur john_thompson = new Professeur().builder().nom("THOMPSON").prenom("John").build();
		
		Formation spring_Framework_5 = new Formation().builder().titre("Spring_FrameWork_5").typeFormat("Ecrit").
				                                       prix(10).contenu("cette formation concerne Spring 5").build();
		
		Formation spring_microServices = new Formation().builder().titre("Spring_MicroServices_5").typeFormat("Ecrit").
													   prix(10).contenu("Cette formation concerne Spring Micro Services").build();
		
		Formation spring_security = new Formation().builder().titre("Spring_Security_5").typeFormat("Ecrit").
				   									   prix(10).contenu("Cette formation concerne Spring Security").build();
		
		Formation docker = new Formation().builder().titre("Docker").typeFormat("Ecrit").
				   									   prix(10).contenu("Cette formation concerne Docker").build();
		
		spring_Framework_5.setCategorie(informatique);
		spring_Framework_5.setProfesseur(john_thompson);
		
		spring_microServices.setCategorie(informatique);
		spring_microServices.setProfesseur(john_thompson);
		
		spring_security.setCategorie(informatique);
		spring_security.setProfesseur(john_thompson);
		
		docker.setCategorie(informatique);
		docker.setProfesseur(john_thompson);
		
		john_thompson.getFormations().add(spring_Framework_5);
		john_thompson.getFormations().add(spring_microServices);
		john_thompson.getFormations().add(spring_security);
		john_thompson.getFormations().add(docker);
		
		this.professeurRepository.save(john_thompson);
		
		//Les formations créé par le professeur Matthieux CASTON
		
		Professeur matthieux_caston = new Professeur().builder().nom("CASTON").prenom("Matthieux").build();
		
		Formation java_script = new Formation().builder().titre("Java_Script").typeFormat("Ecrit").
                								       prix(10).contenu("cette formation concerne Java Script").build();
		
		Formation node_js = new Formation().builder().titre("Node_JS").typeFormat("Ecrit").
													   prix(10).contenu("cette formation concerne Node JS").build();
		
		java_script.setCategorie(informatique);
		java_script.setProfesseur(matthieux_caston);
		
		node_js.setCategorie(informatique);
		node_js.setProfesseur(matthieux_caston);
		
		matthieux_caston.getFormations().add(java_script);
		matthieux_caston.getFormations().add(node_js);
		
		this.professeurRepository.save(matthieux_caston);
		
		//Les formations créé par le professeur Redouane BOUMZZI
		
        Professeur redouane_boumzzi = new Professeur().builder().nom("BOUMZZI").prenom("Redouane").build();
		
		Formation python = new Formation().builder().titre("Python").typeFormat("Ecrit").
                								       prix(10).contenu("cette formation concerne Python").build();
		
		Formation html = new Formation().builder().titre("Html").typeFormat("Ecrit").
													   prix(10).contenu("cette formation concerne HTML").build();
		
		python.setCategorie(informatique);
		python.setProfesseur(redouane_boumzzi);
		
		html.setCategorie(informatique);
		html.setProfesseur(redouane_boumzzi);
		
		redouane_boumzzi.getFormations().add(python);
		redouane_boumzzi.getFormations().add(html);
		
		this.professeurRepository.save(redouane_boumzzi);
		
		//Les formations créé par le professeur Khaled BOUMZZI
		
		Professeur khaled_boumzzi = new Professeur().builder().nom("BOUMZZI").prenom("Khaled").build();
		
		Formation reseaux = new Formation().builder().titre("Réseau Informatique").typeFormat("Ecrit").
                								       prix(10).contenu("cette formation concerne Réseau Informatique").build();
		
		reseaux.setCategorie(informatique);
		reseaux.setProfesseur(khaled_boumzzi);	
		
		khaled_boumzzi.getFormations().add(reseaux);
		
		this.professeurRepository.save(khaled_boumzzi);

	}

}
