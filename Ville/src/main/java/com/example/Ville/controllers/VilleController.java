
package com.example.Ville.controllers;

import com.example.Ville.dtos.VilleDto;
import com.example.Ville.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {

    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VilleDto> getVilleById(@PathVariable Long id) {
        VilleDto ville = villeService.getVilleById(id);
        if (ville != null) {
            return new ResponseEntity<>(ville, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<VilleDto> createVille(@RequestBody VilleDto villeDto) {
        VilleDto createdVille = villeService.createVille(villeDto);
        return new ResponseEntity<>(createdVille, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VilleDto> updateVille(@PathVariable Long id, @RequestBody VilleDto villeDto) {
        VilleDto updatedVille = villeService.updateVille(id, villeDto);
        return new ResponseEntity<>(updatedVille, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable Long id) {
        villeService.deleteVille(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
