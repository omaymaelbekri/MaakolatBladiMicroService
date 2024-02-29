package com.example.Ville.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@Data
public class VilleDto implements Serializable {
   private Long id;
  private   String nom;
    private Long regionId;
}