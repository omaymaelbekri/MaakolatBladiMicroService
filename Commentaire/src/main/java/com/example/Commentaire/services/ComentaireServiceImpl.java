package com.example.Commentaire.services;


import com.example.Commentaire.dtos.ComentaireDto;
import com.example.Commentaire.entities.Comentaire;
import com.example.Commentaire.repositories.ComentaireRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentaireServiceImpl implements ComentaireService {

    private final ComentaireRepository comentaireRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ComentaireServiceImpl(ComentaireRepository comentaireRepository, ModelMapper modelMapper) {
        this.comentaireRepository = comentaireRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ComentaireDto> getAllComentaires(long id) {
        List<Comentaire> comentaires = comentaireRepository.findAllById_post(id);
        return comentaires.stream()
                .map(comentaire -> modelMapper.map(comentaire, ComentaireDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public ComentaireDto getComentaireById(Long id) {
        Optional<Comentaire> comentaireOptional = comentaireRepository.findById(id);
        return comentaireOptional.map(comentaire -> modelMapper.map(comentaire, ComentaireDto.class)).orElse(null);
    }
    @Override
    public ComentaireDto createComentaire(ComentaireDto comentaireDto) {
        Comentaire comentaire = modelMapper.map(comentaireDto, Comentaire.class);
        Comentaire savedComentaire = comentaireRepository.save(comentaire);
        return modelMapper.map(savedComentaire, ComentaireDto.class);
    }
    @Override
    public ComentaireDto updateComentaire(Long id, ComentaireDto comentaireDto) {
        Comentaire existingComentaire = comentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentaire not found with id: " + id));

        // Update existingComentaire with fields from comentaireDto

        Comentaire updatedComentaire = comentaireRepository.save(existingComentaire);
        return modelMapper.map(updatedComentaire, ComentaireDto.class);
    }
    @Override
    public void deleteComentaire(Long id) {
        Comentaire existingComentaire = comentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentaire not found with id: " + id));
        existingComentaire.setIsdeleted(true);
        comentaireRepository.save(existingComentaire);
    }
}
