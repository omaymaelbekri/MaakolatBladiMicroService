package com.example.Utilisateur.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="utilisateur")
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long idcompte;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String tele;


}
