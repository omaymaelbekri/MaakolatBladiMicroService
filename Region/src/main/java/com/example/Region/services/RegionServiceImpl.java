


package com.example.Region.services;

import com.example.Region.dtos.RegionDto;
import com.example.Region.entities.Region;
import com.example.Region.repositories.RegionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository, ModelMapper modelMapper) {
        this.regionRepository = regionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RegionDto> getAllRegions() {
        List<Region> regions = regionRepository.findAll();
        return regions.stream()
                .map(region -> modelMapper.map(region, RegionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RegionDto getRegionById(Long id) {
        Optional<Region> regionOptional = regionRepository.findById(id);
        return regionOptional.map(region -> modelMapper.map(region, RegionDto.class)).orElse(null);
    }

    @Override
    public RegionDto createRegion(RegionDto regionDto) {
        Region region = modelMapper.map(regionDto, Region.class);
        Region savedRegion = regionRepository.save(region);
        return modelMapper.map(savedRegion, RegionDto.class);
    }

    @Override
    public RegionDto updateRegion(Long id, RegionDto regionDto) {
        Region existingRegion = regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + id));

        // Update existingRegion with fields from regionDto
        existingRegion.setNom(regionDto.getNom());

        Region updatedRegion = regionRepository.save(existingRegion);
        return modelMapper.map(updatedRegion, RegionDto.class);
    }

    @Override
    public void deleteRegion(Long id) {
        Region existingRegion = regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + id));
        existingRegion.setIsdeleted(true);
        regionRepository.save(existingRegion);
    }
}

