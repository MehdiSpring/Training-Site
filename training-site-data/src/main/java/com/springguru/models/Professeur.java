package com.springguru.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professeur extends Utilisateur{
	
	@OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL)
	Set<Formation> formations = new HashSet<Formation>();
	
	@Builder
	public Professeur(String nom, String prenom)
	{
		super(nom, prenom);
	}

}
