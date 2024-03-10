package com.example.Plat.controllers;


import com.example.Plat.dtos.PlatDto;
import com.example.Plat.services.PlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plats")
public class PlatController {

    private final PlatService platService;

    @Autowired
    public PlatController(PlatService platService) {
        this.platService = platService;
    }

    @GetMapping
    public ResponseEntity<List<PlatDto>> getAllPlats() {
        List<PlatDto> plats = platService.getAllPlats();
        return new ResponseEntity<>(plats, HttpStatus.OK);
    }

    @GetMapping("platsResto/{id}")
    public ResponseEntity<List<PlatDto>> getAllPlatsByIdResto(@PathVariable("id") Long id) {
        List<PlatDto> plats = platService.getAllPlatsByIdResto(id);
        return new ResponseEntity<>(plats, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlatDto> getPlatById(@PathVariable("id") Long id) {
        PlatDto plat = platService.getPlatById(id);
        if (plat != null) {
            return new ResponseEntity<>(plat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PlatDto> savePlat(@RequestBody PlatDto platDto) {
        PlatDto savedPlat = platService.savePlat(platDto);
        return new ResponseEntity<>(savedPlat, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlat(@PathVariable("id") Long id) {
        platService.deletePlat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

