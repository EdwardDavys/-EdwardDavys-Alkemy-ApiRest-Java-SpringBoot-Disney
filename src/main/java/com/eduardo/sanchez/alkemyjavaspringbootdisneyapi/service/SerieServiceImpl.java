package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.mapper;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.SerieRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.SerieResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Genero;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Personaje;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Serie;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SerieServiceImpl implements SerieService{

        private final SerieRepository serieRepository;
        private final PersonajeService personajeService;
        private final GeneroService generoService;

    public SerieServiceImpl(SerieRepository serieRepository, PersonajeService personajeService, GeneroService generoService) {
        this.serieRepository = serieRepository;
        this.personajeService = personajeService;
        this.generoService = generoService;
    }


    @Override
    public SerieResponseDto addSerie(SerieRequestDto serieRequestDto) {
        Serie serie = new Serie();
        serie.setImagen(serieRequestDto.getImagen());
        serie.setTitulo(serieRequestDto.getTitulo());
        serie.setFechaCreacion(serieRequestDto.getFechaCreacion());
        serie.setCalificacion(serieRequestDto.getCalificacion());
        if (serieRequestDto.getPersonajeIds().isEmpty()){
            throw new IllegalArgumentException("La serie Nesecita  un ersonaje");
        }else{
            List<Personaje> personajes = new ArrayList<>();
            for (Long personajeId: serieRequestDto.getPersonajeIds()){
                Personaje personaje = personajeService.getPersonaje(personajeId);
                personajes.add(personaje);
            }
            serie.setPersonajes(personajes);
        }
        if (serieRequestDto.getGeneroId()==null){
            throw new IllegalArgumentException("La Serie nesecita un genero");
        }
        Genero genero = generoService.getGenero(serieRequestDto.getGeneroId());
        serie.setGenero(genero);

        Serie serie1 = serieRepository.save(serie);

        return mapper.serieParaSerieResponseDto(serie1);

    }

    @Override
    public SerieResponseDto getSerieById(Long serieId) {
        return null;
    }

    @Override
    public Serie getSerie(Long serieId) {
        return null;
    }

    @Override
    public SerieResponseDto deleteSerie(Long serieId) {
        return null;
    }

    @Override
    public SerieResponseDto editSerie(Long serieId, SerieRequestDto serieRequestDto) {
        return null;
    }

    @Override
    public SerieResponseDto addPersonajeToSerie(Long serieId, Long personajeId) {
        return null;
    }

    @Override
    public SerieResponseDto deletePersonajeFromSerie(Long serieId, Long personajeId) {
        return null;
    }

    @Override
    public SerieResponseDto addGeneroToSerie(Long serieId, Long generoId) {
        return null;
    }
}
