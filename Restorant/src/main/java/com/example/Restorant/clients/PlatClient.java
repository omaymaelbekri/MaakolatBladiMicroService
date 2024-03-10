package com.example.Restorant.clients;

import com.example.Plat.dtos.PlatDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(path = "http://localhost:8080/api/plats")
public interface PlatClient {
    @GetMapping("platsResto/{id}")
     ResponseEntity<List<PlatDto>> getAllPlatsByIdResto(@PathVariable("id") Long id);
}
