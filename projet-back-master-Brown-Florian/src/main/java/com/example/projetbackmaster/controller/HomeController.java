package com.example.projetbackmaster.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetbackmaster.dto.ChartDTO;
import com.example.projetbackmaster.dto.GenreDTO;
import com.example.projetbackmaster.dto.HomeDTO;
import com.example.projetbackmaster.dto.IndicateurDTO;
import com.example.projetbackmaster.dto.LivreDTO;
import com.example.projetbackmaster.entity.LivreEntity;
import com.example.projetbackmaster.enums.AuteurEnum;
import com.example.projetbackmaster.mapper.LivreMapper;
import com.example.projetbackmaster.service.AuteurService;
import com.example.projetbackmaster.service.LivreService;

@RestController
@RequestMapping(value = "/rest/bd/home")
public class HomeController {
	
	@Autowired
	private LivreService servicelivre;
	
	@Autowired
	private AuteurService serviceauteur;
	
	@GetMapping
	public HomeDTO getHome() {
		
		IndicateurDTO indicateurs = new IndicateurDTO();
		
		List list = new ArrayList();
		for(final LivreEntity entity : servicelivre.findLivres()) {
			if(!list.contains(entity.getGenre())) {
				list.add(entity.getGenre());
			}
		}
		indicateurs.setNbGenres(list.size());
		indicateurs.setNbLivres(servicelivre.findLivres().size());
		indicateurs.setNbAuteurs(serviceauteur.findAuteurs().size());
		
		
		
		GenreDTO ListeGenre = new GenreDTO();
		
		Map<String, Integer> tab = new HashMap();
		List<LivreEntity> entities = servicelivre.findLivres();
		for (int i = 0; i < entities.size(); i++){
    		LivreEntity livre = entities.get(i);
    		String genre =  livre.getGenre().toString();
    		boolean existe = tab.containsKey(genre);
    		if(!existe) {
    	    	tab.put(genre, 1);
    		}else{
    	    	tab.put(genre, tab.get(genre) + 1);
    	    }
    	}
		
		ListeGenre.setListeGenre(tab);
		
		
		
		List<String> colors = new ArrayList<String>(); 
        List<String> labels = new ArrayList<String>(); 
        List<Integer> values = new ArrayList<Integer>(); 
        ArrayList<Integer> graphGenreNb = new ArrayList<Integer>();
        ArrayList<String> graphLabels = new ArrayList<String>();
        graphGenreNb = servicelivre.findNbGenre();
        graphLabels = servicelivre.findGenre();
        
        for (int i = 0; i < graphLabels.size(); i++){
      	  labels.add(graphLabels.get(i));
      	  values.add(graphGenreNb.get(i));
      	}
  	
	    colors.add("#0B162C");
	    colors.add("#1C2942");
	    colors.add("#3B556D");
	    colors.add("#06668C");
	    colors.add("#5FC2BA");
	
	    ChartDTO Chart = new ChartDTO();
	    
	    Chart.setColors(colors);
	    Chart.setLabels(labels);
	    Chart.setValues(values);
	  
	    
	    
		HomeDTO home = new HomeDTO();
		
		home.setDatasGraph(Chart);
		home.setLivres(LivreMapper.map(servicelivre.findLivres()));
		home.setIndicateurs(indicateurs);
		home.setGenres(tab);
		
		return home;
		
	}

}
