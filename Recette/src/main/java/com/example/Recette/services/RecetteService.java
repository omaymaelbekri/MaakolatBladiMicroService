package com.example.Recette.services;


import com.example.Recette.dtos.RecetteDto;

import java.util.List;

public interface RecetteService {
    List<RecetteDto> getAllRecettes();
    RecetteDto getRecetteById(Long id);
    RecetteDto saveRecette(RecetteDto recetteDTO);
    void deleteRecette(Long id);


}
