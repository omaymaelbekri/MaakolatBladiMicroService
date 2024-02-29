package com.example.Plat.services;



import com.example.Plat.dtos.PlatDto;

import java.util.List;

public interface IPlatService {
    List<PlatDto> getAllPlats();
    PlatDto getPlatById(Long id);
    PlatDto savePlat(PlatDto platDTO);
    void deletePlat(Long id);
}
