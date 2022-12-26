package com.example.projetbackmaster.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.projetbackmaster.enums.AuteurEnum;

@Entity
@Table(name="livres")
public class LivreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String editeur;
	private Integer nbPages;
	private Date dateParution;
	private String lieuParution;
	
	@Enumerated(EnumType.STRING)
	private AuteurEnum genre;
	
	@ManyToOne()
    @JoinColumn(name="auteur", referencedColumnName = "id")    
    private AuteurEntity auteur;
	
	
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
	public AuteurEntity getAuteur() {
		return auteur;
	}

	public void setAuteur(AuteurEntity auteur) {
		this.auteur = auteur;
	}
	
	

}
