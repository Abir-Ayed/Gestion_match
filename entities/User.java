package com.example.qatar.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity

public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

@Column(name ="id_user")
	private Long id;
	private String email;
	private String pwd;
	private String prenom;
	private String nom;
	public Long getId() {
		return id;
	}
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "USER_ROLES")
	    private Set<Role> roles;
	
	
	public User(String email, String pwd, String prenom, String nom, Set<Role> roles) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.prenom = prenom;
		this.nom = nom;
		this.roles = roles;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pwd=" + pwd + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
