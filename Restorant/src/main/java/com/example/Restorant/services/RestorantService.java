package com.example.Restorant.services;



import com.example.Restorant.dtos.RestorantDto;

import java.util.List;

public interface RestorantService {
    List<RestorantDto> getAllRestorants();
    RestorantDto getRestorantById(Long id);
    RestorantDto saveRestorant(RestorantDto restorantDTO);
    void deleteRestorant(Long id);

}
