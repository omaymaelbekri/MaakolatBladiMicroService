package com.example.Administrateur.controllers;


import com.example.Administrateur.dtos.AdministrateurDto;
import com.example.Administrateur.services.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrateurs")
public class AdministrateurController {

    private final AdministrateurService administrateurService;

    @Autowired
    public AdministrateurController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }

    @GetMapping
    public ResponseEntity<List<AdministrateurDto>> getAllAdministrateurs() {
        List<AdministrateurDto> administrateurs = administrateurService.getAllAdministrateurs();
        return new ResponseEntity<>(administrateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministrateurDto> getAdministrateurById(@PathVariable("id") Long id) {
        AdministrateurDto administrateur = administrateurService.getAdministrateurById(id);
        if (administrateur != null) {
            return new ResponseEntity<>(administrateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AdministrateurDto> saveAdministrateur(@RequestBody AdministrateurDto administrateurDto) {
        AdministrateurDto savedAdministrateur = administrateurService.saveAdministrateur(administrateurDto);
        return new ResponseEntity<>(savedAdministrateur, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrateur(@PathVariable("id") Long id) {
        administrateurService.deleteAdministrateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
