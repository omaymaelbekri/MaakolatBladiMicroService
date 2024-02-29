package com.example.Restorant.services;


import com.example.Restorant.dtos.RestorantDto;
import com.example.Restorant.entities.Restorant;
import com.example.Restorant.repositories.RestorantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestorantServiceImp implements RestorantService {

    private final RestorantRepository restorantRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RestorantServiceImp(RestorantRepository restorantRepository, ModelMapper modelMapper) {
        this.restorantRepository = restorantRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<RestorantDto> getAllRestorants() {
        List<Restorant> restorants = restorantRepository.findAll();
        return restorants.stream()
                .map(restorant -> modelMapper.map(restorant, RestorantDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public RestorantDto getRestorantById(Long id) {
        Optional<Restorant> restorantOptional = restorantRepository.findById(id);
        return restorantOptional.map(restorant -> modelMapper.map(restorant, RestorantDto.class)).orElse(null);
    }
    @Override
    public RestorantDto saveRestorant(RestorantDto restorantDTO) {
        Restorant restorant = modelMapper.map(restorantDTO, Restorant.class);
        restorant = restorantRepository.save(restorant);
        return modelMapper.map(restorant, RestorantDto.class);
    }
    @Override
    public void deleteRestorant(Long id) {
        restorantRepository.deleteById(id);
    }
}

