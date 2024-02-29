package com.example.Plat.repositories;

import com.example.Plat.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatRepository extends JpaRepository<Plat, Long> {
}