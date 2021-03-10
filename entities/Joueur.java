package com.example.qatar.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Joueur implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

@Column(name ="id_joueur")
	private Long id;
	private String prenom;
	private String nom;
	private int num_maillot;
	private int age;
	private String filiere;
	@ManyToOne
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;
	public Joueur(String prenom, String nom, int num_maillot, int age, String filiere, Equipe equipe) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.num_maillot = num_maillot;
		this.age = age;
		this.filiere = filiere;
		this.equipe = equipe;
	}
	
	
	
	
}
