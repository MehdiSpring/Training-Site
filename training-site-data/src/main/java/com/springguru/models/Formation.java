package com.springguru.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Formation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	private double prix;
	private String typeFormat;
	private String contenu;
	
	@ManyToOne
	private Categorie categorie;
	
	@ManyToMany
	@JoinTable(name = "Formations_Etudiants", joinColumns = @JoinColumn(name="id_Formation"),
	inverseJoinColumns = @JoinColumn(name="id_Etudiant"))
	private Set<Etudiant> etudiants = new HashSet<Etudiant>();
	
	@ManyToOne
	private Professeur professeur;

}
