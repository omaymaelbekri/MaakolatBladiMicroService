package com.example.Region.controllers;

import com.example.Region.dtos.RegionDto;
import com.example.Region.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionDto> getRegionById(@PathVariable Long id) {
        RegionDto region = regionService.getRegionById(id);
        if (region != null) {
            return new ResponseEntity<>(region, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RegionDto> createRegion(@RequestBody RegionDto regionDto) {
        RegionDto createdRegion = regionService.createRegion(regionDto);
        return new ResponseEntity<>(createdRegion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionDto> updateRegion(@PathVariable Long id, @RequestBody RegionDto regionDto) {
        RegionDto updatedRegion = regionService.updateRegion(id, regionDto);
        return new ResponseEntity<>(updatedRegion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

