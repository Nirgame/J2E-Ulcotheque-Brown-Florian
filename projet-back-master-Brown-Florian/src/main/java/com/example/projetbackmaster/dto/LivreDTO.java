package com.example.projetbackmaster.dto;

import java.sql.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.projetbackmaster.entity.AuteurEntity;
import com.example.projetbackmaster.enums.AuteurEnum;

public class LivreDTO {

	private Integer id;
	private String nom;
	private String editeur;
	private Integer nbPages;
	private Date dateParution;
	private String lieuParution;
	@Enumerated(EnumType.STRING)
	private AuteurEnum genre;
	private AuteurEntity auteur;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public Integer getNbPages() {
		return nbPages;
	}
	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	public String getLieuParution() {
		return lieuParution;
	}
	public void setLieuParution(String lieuParution) {
		this.lieuParution = lieuParution;
	}
	public AuteurEnum getGenre() {
		return genre;
	}
	public void setGenre(AuteurEnum genre) {
		this.genre = genre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AuteurEntity getAuteur() {
		return auteur;
	}
	public void setAuteur(AuteurEntity auteur) {
		this.auteur = auteur;
	}
	
}
