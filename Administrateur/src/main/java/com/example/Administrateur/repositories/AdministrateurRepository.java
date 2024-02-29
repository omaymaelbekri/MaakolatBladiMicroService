package com.example.Administrateur.repositories;

import com.example.Administrateur.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
}