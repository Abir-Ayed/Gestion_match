package com.example.qatar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter


public class Arbitre {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

@Column(name ="id_arbitre")
	private Long id;
	
	private String nom;
	private String prenom;
	private String filiere;
	
	@ManyToOne
	@JoinColumn(name = "matcheid")
	private Matche matche;

	public Arbitre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arbitre(String nom, String prenom, String filiere, Matche matche) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.matche = matche;
	}


}
