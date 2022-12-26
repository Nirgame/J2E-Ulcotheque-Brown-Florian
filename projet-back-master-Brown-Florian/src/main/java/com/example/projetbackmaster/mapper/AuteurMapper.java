package com.example.projetbackmaster.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.projetbackmaster.dto.AuteurDTO;
import com.example.projetbackmaster.entity.AuteurEntity;

public class AuteurMapper {

	public static AuteurDTO map(AuteurEntity entity) {
        AuteurDTO auteur = new AuteurDTO();
          
          
        auteur.setId(entity.getId()); 
        auteur.setNom(entity.getNom());
        auteur.setPrenom(entity.getPrenom());
        auteur.setDate_naissance(entity.getDate_Naissance());

          return auteur;
         
    }
    
    //Permet de récupérer les auteurs
    public static List<AuteurDTO> map(List<AuteurEntity> AuteursEntity){
        if(null == AuteursEntity) {
            return null;
        }
        List<AuteurDTO> result = new ArrayList<AuteurDTO>();
        for(final AuteurEntity auteur : AuteursEntity) {
            result.add(AuteurMapper.map(auteur));
        }
        
        return result;
    }
}
