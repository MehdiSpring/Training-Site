package com.springguru.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Etudiant extends Utilisateur{
	
	@ManyToMany(mappedBy = "etudiants")
	private Set<Formation> formations = new HashSet<Formation>();

}
