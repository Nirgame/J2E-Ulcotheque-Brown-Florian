package com.example.projetbackmaster.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="auteurs")
public class AuteurEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private Date date_naissance;
	
	@OneToMany(targetEntity=LivreEntity.class, mappedBy="auteur",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LivreEntity> livres;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_Naissance() {
		return date_naissance;
	}
	public void setDate_Naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

}
