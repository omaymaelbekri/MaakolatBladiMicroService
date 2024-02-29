package com.example.Commentaire.repositories;


import com.example.Commentaire.entities.Comentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentaireRepository extends JpaRepository<Comentaire, Long> {
    List<Comentaire> findAllByIsdeletedFalse();
    List<Comentaire> findAllById_post(long id );
}