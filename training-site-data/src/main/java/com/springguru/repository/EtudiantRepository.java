package com.springguru.repository;

import org.springframework.data.repository.CrudRepository;

import com.springguru.models.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {

}
