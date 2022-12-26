package com.example.projetbackmaster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetbackmaster.entity.LivreEntity;
import com.example.projetbackmaster.enums.AuteurEnum;
import com.example.projetbackmaster.repository.LivreRepository;

@Service
public class LivreService {

	@Autowired
	private LivreRepository repo;
	
	public List<LivreEntity> findLivres(){
		return repo.findAll();
	}
	
	public LivreEntity findById(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
	
	public void Add_Update(LivreEntity livre) {
		repo.save(livre);
	}
	
	 public List<LivreEntity> findByGenre(AuteurEnum genre){
		 return repo.findLivresByGenre(genre);
	}
	 
	 public ArrayList<Integer> findNbGenre() {
	    return repo.findGenreNb();
	 }
	    
	    
	 public ArrayList<String> findGenre() {
	    return repo.findGenre();
	 }
	 
}
