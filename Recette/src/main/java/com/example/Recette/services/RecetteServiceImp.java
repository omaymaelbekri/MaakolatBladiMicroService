package com.example.Recette.services;


import com.example.Recette.dtos.RecetteDto;
import com.example.Recette.entities.Recette;
import com.example.Recette.repositories.RecetteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecetteServiceImp implements RecetteService {

    private final RecetteRepository recetteRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RecetteServiceImp(RecetteRepository recetteRepository, ModelMapper modelMapper) {
        this.recetteRepository = recetteRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<RecetteDto> getAllRecettes() {
        List<Recette> recettes = recetteRepository.findAll();
        return recettes.stream()
                .map(recette -> modelMapper.map(recette, RecetteDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public RecetteDto getRecetteById(Long id) {
        Optional<Recette> recetteOptional = recetteRepository.findById(id);
        return recetteOptional.map(recette -> modelMapper.map(recette, RecetteDto.class)).orElse(null);
    }
    @Override
    public RecetteDto saveRecette(RecetteDto recetteDTO) {
        Recette recette = modelMapper.map(recetteDTO, Recette.class);
        recette = recetteRepository.save(recette);
        return modelMapper.map(recette, RecetteDto.class);
    }
    @Override
    public void deleteRecette(Long id) {
        recetteRepository.deleteById(id);
    }
}

