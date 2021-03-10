package com.example.qatar.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.qatar.entities.Arbitre;
import com.example.qatar.entities.Joueur;

public interface JoueurDao  extends CrudRepository<Joueur,Long> {

}
