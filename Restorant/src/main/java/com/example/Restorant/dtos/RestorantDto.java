package com.example.Restorant.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class RestorantDto implements Serializable {
    long id;
    String nom;
    long idville;
    String adresse;
    String email;
    String tele;
    long idcompte;
}