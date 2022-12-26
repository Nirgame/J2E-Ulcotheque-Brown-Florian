package com.example.projetbackmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetbackmaster.dto.AuteurDTO;
import com.example.projetbackmaster.mapper.AuteurMapper;
import com.example.projetbackmaster.service.AuteurService;

@RestController
@RequestMapping(value = "/rest/bd/auteurs")
public class AuteurController {
	
	@Autowired
	private AuteurService service;
	
	@GetMapping
	public List<AuteurDTO> findAuteurs(){
		return AuteurMapper.map(service.findAuteurs());
	}
	
	@GetMapping(value="{id}")
	public AuteurDTO findAuteurById(@PathVariable Integer id){
		return AuteurMapper.map(service.findAuteurById(id));
	}

}
