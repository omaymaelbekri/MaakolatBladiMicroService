package com.example.Administrateur.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AdministrateurDto implements Serializable {
    String nom;
    String prenom;
    String adresse;
    String email;
    String tele;
    Long id;
    long idcompte;
}