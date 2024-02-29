package com.example.Recette.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="recette")
@NoArgsConstructor
public class Recette {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     private String nom;
     private String description;
     private String image;
     private  long  idutilisateur;
     private long idville ;
     private LocalDateTime createdAt;
     private int likes;
}
