package com.example.projetbackmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetbackmaster.dto.LivreDTO;
import com.example.projetbackmaster.enums.AuteurEnum;
import com.example.projetbackmaster.mapper.LivreMapper;
import com.example.projetbackmaster.service.LivreService;

@RestController
@RequestMapping(value = "/rest/bd/livres")
public class LivreController {
	
	@Autowired
	private LivreService service;
	
	@GetMapping
	public List<LivreDTO> findLivres(){
		return LivreMapper.map(service.findLivres());
	}
	
	@GetMapping(value="{id}")
	public LivreDTO findById(@PathVariable Integer id) {
		return LivreMapper.map(service.findById(id));
	}
	
	@DeleteMapping(value="{id}")
	public void deleteLivre(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
	@PostMapping()
	public void insertLivre(@RequestBody LivreDTO livre) {
		service.Add_Update(LivreMapper.save(livre));
	}
	@PutMapping(value="{id}")
	public void updateLivre(@PathVariable Integer id,@RequestBody LivreDTO livre) {
		service.Add_Update(LivreMapper.edit(service.findById(id),livre));
	}
	
	@GetMapping("livres")
	public List<LivreDTO> findByGenre(@RequestParam AuteurEnum genre){
		return LivreMapper.map(service.findByGenre(genre));
	}
	
}
