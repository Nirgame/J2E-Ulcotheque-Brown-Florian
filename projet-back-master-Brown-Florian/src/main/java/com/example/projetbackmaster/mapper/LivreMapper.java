package com.example.projetbackmaster.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.projetbackmaster.dto.LivreDTO;
import com.example.projetbackmaster.entity.LivreEntity;

public class LivreMapper {

	public static LivreDTO map(LivreEntity entity) {
		LivreDTO livre = new LivreDTO();
		
		livre.setId(entity.getId());
		livre.setNom(entity.getNom());
		livre.setNbPages(entity.getNbPages());
		livre.setDateParution(entity.getDateParution());
		livre.setEditeur(entity.getEditeur());
		livre.setGenre(entity.getGenre());
		livre.setLieuParution(entity.getLieuParution());
		livre.setAuteur(entity.getAuteur());
		
		return livre;
	}
	
	public static LivreEntity save(LivreDTO entity) {
		LivreEntity livre = new LivreEntity();
		
		livre.setNom(entity.getNom());
		livre.setNbPages(entity.getNbPages());
		livre.setDateParution(entity.getDateParution());
		livre.setEditeur(entity.getEditeur());
		livre.setGenre(entity.getGenre());
		livre.setLieuParution(entity.getLieuParution());
		livre.setAuteur(entity.getAuteur());
		
		return livre;
	}
	
public static LivreEntity edit(LivreEntity old,LivreDTO entity) {
		
		old.setNom(entity.getNom());
		old.setNbPages(entity.getNbPages());
		old.setDateParution(entity.getDateParution());
		old.setEditeur(entity.getEditeur());
		old.setGenre(entity.getGenre());
		old.setLieuParution(entity.getLieuParution());
		old.setAuteur(entity.getAuteur());
		
		return old;
		
	}
	
	/*
	public static HomeDTO maphome(List<LivreEntity> list) {
		HomeDTO homelivre = new HomeDTO();
		homelivre.setLivres(LivreMapper.map(list));	
		return homelivre;
	}*/
	
	public static List<LivreDTO> map(List<LivreEntity> entities){
		if(null == entities) {
			return null;
		}
		List<LivreDTO> result = new ArrayList<LivreDTO>();
		for(final LivreEntity livre : entities) {
			result.add(LivreMapper.map(livre));
		}
		
		return result;
	}
	
}
