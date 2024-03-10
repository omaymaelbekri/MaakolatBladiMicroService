package com.example.Plat.services;


import com.example.Plat.dtos.PlatDto;
import com.example.Plat.entities.Plat;
import com.example.Plat.repositories.PlatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlatService implements IPlatService {

    private final PlatRepository platRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlatService(PlatRepository platRepository, ModelMapper modelMapper) {
        this.platRepository = platRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<PlatDto> getAllPlats() {
        List<Plat> plats = platRepository.findAll();
        return plats.stream()
                .map(plat -> modelMapper.map(plat, PlatDto.class))
                .collect(Collectors.toList());
    }
    public List<PlatDto> getAllPlatsByIdResto(long id) {
        List<Plat> plats = platRepository.findAllByIdresto(id);
        return plats.stream()
                .map(plat -> modelMapper.map(plat, PlatDto.class))
                .collect(Collectors.toList());
    }
    @Override

    public PlatDto getPlatById(Long id) {
        Optional<Plat> platOptional = platRepository.findById(id);
        return platOptional.map(plat -> modelMapper.map(plat, PlatDto.class)).orElse(null);
    }
    @Override
    public PlatDto savePlat(PlatDto platDTO) {
        Plat plat = modelMapper.map(platDTO, Plat.class);
        plat = platRepository.save(plat);
        return modelMapper.map(plat, PlatDto.class);
    }
    @Override
    public void deletePlat(Long id) {
        platRepository.deleteById(id);
    }
}

