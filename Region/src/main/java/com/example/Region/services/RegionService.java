package com.example.Region.services;

import com.example.Region.dtos.RegionDto;

import java.util.List;

public interface RegionService {
    default List<RegionDto> getAllRegions(){
        return null;
    }




    default RegionDto getRegionById(Long id){
        return null;
    }
    default RegionDto createRegion(RegionDto regionDto){
        return null;
    }
    default  RegionDto updateRegion(Long id, RegionDto regionDto){
        return regionDto;
    }
    default  void deleteRegion(Long id){}
}
