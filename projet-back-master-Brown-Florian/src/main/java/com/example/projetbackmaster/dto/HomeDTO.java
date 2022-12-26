package com.example.projetbackmaster.dto;

import java.util.List;
import java.util.Map;


public class HomeDTO {

	private List<LivreDTO> livres;
	private IndicateurDTO indicateurs;
    private Map<String,Integer> genres;
	private ChartDTO datasGraph;
	
	public List<LivreDTO> getLivres() {
		return livres;
	}
	public void setLivres(List<LivreDTO> livres) {
		this.livres = livres;
	}
	public IndicateurDTO getIndicateurs() {
		return indicateurs;
	}
	public void setIndicateurs(IndicateurDTO indicateurs) {
		this.indicateurs = indicateurs;
	}
	public Map<String,Integer> getGenres() {
		return genres;
	}
	public void setGenres(Map<String,Integer> genres) {
		this.genres = genres;
	}
	public ChartDTO getDatasGraph() {
		return datasGraph;
	}
	public void setDatasGraph(ChartDTO datasGraph) {
		this.datasGraph = datasGraph;
	}
}
