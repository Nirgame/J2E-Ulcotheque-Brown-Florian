package com.example.projetbackmaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetbackmaster.entity.AuteurEntity;
import com.example.projetbackmaster.repository.AuteurRepository;

@Service
public class AuteurService {
	
	@Autowired
	private AuteurRepository repo;
	
	public List<AuteurEntity> findAuteurs(){
		return repo.findAll();
	}
	public AuteurEntity findAuteurById(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
}
