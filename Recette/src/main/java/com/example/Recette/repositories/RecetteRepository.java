package com.example.Recette.repositories;

import com.example.Recette.entities.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
}