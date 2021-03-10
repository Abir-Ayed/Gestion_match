package com.example.qatar.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Equipe implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

@Column(name ="id_equipe")
	private Long id;
	
	private String nom;
	
	
	private String pays;

	@OneToMany(mappedBy="equipe",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	Set<Joueur> joueurs =  new HashSet<>();
	
	@ManyToMany(mappedBy="equipes",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	Set<Matche> matchs =  new HashSet<>();

	public Equipe(String nom, String pays, Set<Joueur> joueurs, Set<Matche> matchs) {
		super();
		this.nom = nom;
		this.pays = pays;
		this.joueurs = joueurs;
		this.matchs = matchs;
	}

	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
