package com.example.Ville.services;





import com.example.Ville.dtos.VilleDto;

import java.util.List;

public interface VilleService {
    default List<VilleDto> getAllVilles(){
        return null;
    }
    default VilleDto getVilleById(Long id){
        return null;
    }
    default VilleDto  createVille(VilleDto villeDto){
        return villeDto;
    }
    default VilleDto updateVille(Long id, VilleDto villeDto){
        return villeDto;
    }
    default void deleteVille(Long id){}
}
