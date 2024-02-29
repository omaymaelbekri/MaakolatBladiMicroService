package com.example.Utilisateur.services;

import com.example.Utilisateur.entities.Utilisateur;
import com.example.Utilisateur.entities.UtilisateurDto;
import com.example.Utilisateur.repositories.UtilisateurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImp implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UtilisateurServiceImp(UtilisateurRepository utilisateurRepository, ModelMapper modelMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map(utilisateur -> modelMapper.map(utilisateur, UtilisateurDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public UtilisateurDto getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.map(utilisateur -> modelMapper.map(utilisateur, UtilisateurDto.class)).orElse(null);
    }
    @Override
    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDTO) {
        Utilisateur utilisateur = modelMapper.map(utilisateurDTO, Utilisateur.class);
        utilisateur = utilisateurRepository.save(utilisateur);
        return modelMapper.map(utilisateur, UtilisateurDto.class);
    }
    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}

