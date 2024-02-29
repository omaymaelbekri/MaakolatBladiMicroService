package com.example.Utilisateur.services;


import com.example.Utilisateur.entities.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    List<UtilisateurDto> getAllUtilisateurs();
    UtilisateurDto getUtilisateurById(Long id);
    UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDTO);
   void deleteUtilisateur(Long id);
}
