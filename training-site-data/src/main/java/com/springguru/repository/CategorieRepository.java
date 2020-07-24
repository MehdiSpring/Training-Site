package com.springguru.repository;

import org.springframework.data.repository.CrudRepository;

import com.springguru.models.Categorie;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {

	public Categorie findByTitre(String titre);
}
