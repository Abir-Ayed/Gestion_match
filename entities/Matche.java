package com.example.qatar.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Matche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="matcheid")
	private Long id;
	
	private String tour;
	private String resultat;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMatch;
	
	
	@OneToMany(mappedBy="matche",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	Set<Arbitre> arbitres =  new HashSet<>();
	@ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	
	Set<Equipe> equipes =  new HashSet<>();
	
	
	public Matche() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Matche(String tour, String resultat, Date dateMatch, Set<Arbitre> arbitres, Set<Equipe> equipes) {
		super();
		this.tour = tour;
		this.resultat = resultat;
		this.dateMatch = dateMatch;
		this.arbitres = arbitres;
		this.equipes = equipes;
	}
	
	
	

	
}
