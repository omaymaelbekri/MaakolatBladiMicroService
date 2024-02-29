package com.example.Plat.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class PlatDto implements Serializable {
    Long id;
    String nom;
    String description;
    long idresto;
    float prix;
}