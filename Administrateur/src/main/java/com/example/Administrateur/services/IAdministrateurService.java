package com.example.Administrateur.services;



import com.example.Administrateur.dtos.AdministrateurDto;

import java.util.List;

public interface IAdministrateurService {
    List<AdministrateurDto> getAllAdministrateurs() ;
    AdministrateurDto getAdministrateurById(Long id);
    AdministrateurDto saveAdministrateur(AdministrateurDto administrateurDTO);
    void deleteAdministrateur(Long id);
}
