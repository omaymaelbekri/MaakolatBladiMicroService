package com.example.Administrateur.services;


import com.example.Administrateur.dtos.AdministrateurDto;
import com.example.Administrateur.entities.Administrateur;
import com.example.Administrateur.repositories.AdministrateurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministrateurService implements IAdministrateurService {

    private final AdministrateurRepository administrateurRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository, ModelMapper modelMapper) {
        this.administrateurRepository = administrateurRepository;
        this.modelMapper = modelMapper;
    }
@Override
    public List<AdministrateurDto> getAllAdministrateurs() {
        List<Administrateur> administrateurs = administrateurRepository.findAll();
        return administrateurs.stream()
                .map(administrateur -> modelMapper.map(administrateur, AdministrateurDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public AdministrateurDto getAdministrateurById(Long id) {
        Optional<Administrateur> administrateurOptional = administrateurRepository.findById(id);
        return administrateurOptional.map(administrateur -> modelMapper.map(administrateur, AdministrateurDto.class)).orElse(null);
    }
    @Override
    public AdministrateurDto saveAdministrateur(AdministrateurDto administrateurDTO) {
        Administrateur administrateur = modelMapper.map(administrateurDTO, Administrateur.class);
        administrateur = administrateurRepository.save(administrateur);
        return modelMapper.map(administrateur, AdministrateurDto.class);
    }
    @Override
    public void deleteAdministrateur(Long id) {
        administrateurRepository.deleteById(id);
    }
}
