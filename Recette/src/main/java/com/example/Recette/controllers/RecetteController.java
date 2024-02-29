package com.example.Recette.controllers;

import com.example.Recette.dtos.RecetteDto;
import com.example.Recette.services.RecetteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
public class RecetteController {

    private final RecetteServiceImp recetteService;

    @Autowired
    public RecetteController(RecetteServiceImp recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping
    public ResponseEntity<List<RecetteDto>> getAllRecettes() {
        List<RecetteDto> recettes = recetteService.getAllRecettes();
        return new ResponseEntity<>(recettes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetteDto> getRecetteById(@PathVariable("id") Long id) {
        RecetteDto recette = recetteService.getRecetteById(id);
        if (recette != null) {
            return new ResponseEntity<>(recette, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RecetteDto> saveRecette(@RequestBody RecetteDto recetteDto) {
        RecetteDto savedRecette = recetteService.saveRecette(recetteDto);
        return new ResponseEntity<>(savedRecette, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable("id") Long id) {
        recetteService.deleteRecette(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

