package com.example.Recette.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RecetteDto implements Serializable {
    long id;
    String nom;
    String description;
    String image;
    long idutilisateur;
    long idville;
    LocalDateTime createdAt;
    int likes;
}