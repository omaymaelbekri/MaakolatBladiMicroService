package com.example.Restorant.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

import java.util.List;

@Data
@Entity
@Table(name="restorant")
@SoftDelete
@NoArgsConstructor
public class Restorant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private long idville;
    private String adresse;
    private String email;
    private String tele;
    private  long idcompte;

}
