package com.example.Restorant.controllers;

import com.example.Restorant.dtos.RestorantDto;
import com.example.Restorant.services.RestorantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restorants")
public class RestorantController {

    private final RestorantService restorantService;

    @Autowired
    public RestorantController(RestorantService restorantService) {
        this.restorantService = restorantService;
    }

    @GetMapping
    public ResponseEntity<List<RestorantDto>> getAllRestorants() {
        List<RestorantDto> restorants = restorantService.getAllRestorants();
        return new ResponseEntity<>(restorants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestorantDto> getRestorantById(@PathVariable("id") Long id) {
        RestorantDto restorant = restorantService.getRestorantById(id);
        if (restorant != null) {
            return new ResponseEntity<>(restorant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RestorantDto> saveRestorant(@RequestBody RestorantDto restorantDto) {
        RestorantDto savedRestorant = restorantService.saveRestorant(restorantDto);
        return new ResponseEntity<>(savedRestorant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestorant(@PathVariable("id") Long id) {
        restorantService.deleteRestorant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

