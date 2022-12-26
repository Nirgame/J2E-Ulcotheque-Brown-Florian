package com.example.projetbackmaster.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetbackmaster.entity.LivreEntity;
import com.example.projetbackmaster.enums.AuteurEnum;

@Repository
public interface LivreRepository extends JpaRepository<LivreEntity, Integer>{
	
	@Query(value="SELECT l FROM LivreEntity l where l.genre = :genre")
	List<LivreEntity> findLivresByGenre(@Param("genre") final AuteurEnum genre);
	
	@Query("SELECT genre as labels FROM LivreEntity l GROUP BY l.genre")
	ArrayList<String> findGenre();

	@Query("SELECT count(genre) as values FROM LivreEntity l GROUP BY l.genre")
	ArrayList<Integer> findGenreNb();
	
}
