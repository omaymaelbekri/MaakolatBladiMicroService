package com.example.Commentaire.repositories;


import com.example.Commentaire.entities.Comentaire;
import jakarta.ws.rs.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentaireRepository extends JpaRepository<Comentaire, Long> {
    List<Comentaire> findAllByIsdeletedFalse();
   // List<Comentaire> findAllById_post(long id );
    @Query("select  c from Comentaire c where c.id_post=:id")
    List<Comentaire>findAllById_post(@QueryParam("id") long id );
}