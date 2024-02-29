package com.example.Region.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@Data
public class RegionDto implements Serializable {
    Long id;
    String nom;

}