package com.example.Restorant.repositories;

import com.example.Restorant.entities.Restorant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestorantRepository extends JpaRepository<Restorant, Long> {
}