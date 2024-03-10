package com.example.Plat.repositories;

import com.example.Plat.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatRepository extends JpaRepository<Plat, Long> {

    List<Plat> findAllByIdresto(long id);
}