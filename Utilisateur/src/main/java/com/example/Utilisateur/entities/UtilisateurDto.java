package com.example.Utilisateur.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UtilisateurDto implements Serializable {
    Long id;
    long idcompte;
    String nom;
    String prenom;
    String adresse;
    String email;
    String tele;
}