package com.example.Ville.services;

import com.example.Ville.dtos.VilleDto;
import com.example.Ville.entities.Ville;
import com.example.Ville.repositories.VilleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VilleServiceImpl implements VilleService {

    private final VilleRepository villeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public VilleServiceImpl(VilleRepository villeRepository, ModelMapper modelMapper) {
        this.villeRepository = villeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VilleDto> getAllVilles() {
        List<Ville> villes = villeRepository.findAll();
        return villes.stream()
                .map(ville -> modelMapper.map(ville, VilleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VilleDto getVilleById(Long id) {
        Optional<Ville> villeOptional = villeRepository.findById(id);
        return villeOptional.map(ville -> modelMapper.map(ville, VilleDto.class)).orElse(null);
    }

    @Override
    public VilleDto createVille(VilleDto villeDto) {
        Ville ville = modelMapper.map(villeDto, Ville.class);
        Ville savedVille = villeRepository.save(ville);
        return modelMapper.map(savedVille, VilleDto.class);
    }

    @Override
    public VilleDto updateVille(Long id, VilleDto villeDto) {
        Ville existingVille = villeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ville not found with id: " + id));

        // Update existingVille with fields from villeDto
        existingVille.setNom(villeDto.getNom());
        existingVille.setRegion_id(villeDto.getRegionId());

        Ville updatedVille = villeRepository.save(existingVille);
        return modelMapper.map(updatedVille, VilleDto.class);
    }

    @Override
    public void deleteVille(Long id) {
        Ville existingVille = villeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ville not found with id: " + id));
        existingVille.setIsdeleted(true);
        villeRepository.save(existingVille);
    }
}
