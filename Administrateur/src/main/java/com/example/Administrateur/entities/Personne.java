package com.example.Administrateur.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Personne {
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String tele;

}
