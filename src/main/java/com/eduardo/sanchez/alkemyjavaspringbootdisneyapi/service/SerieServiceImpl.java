package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.mapper;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.SerieRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.SerieResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Genero;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Personaje;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Serie;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository.SerieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


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

    @Transactional
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
        Serie serie = getSerie(serieId);
        return mapper.serieParaSerieResponseDto(serie);
    }

    @Override
    public Serie getSerie(Long serieId) {

        Serie serie = serieRepository.findById(serieId).orElseThrow(()->
                        new IllegalArgumentException("no se encuentra serie con Id: " + serieId));


        return serie;
    }

    @Override
    public List<SerieResponseDto> getSeries() {

        List<Serie>series = StreamSupport
                            .stream(serieRepository.findAll().spliterator(),false)
                            .collect(Collectors.toList());
        return mapper.seriesParaSerieResponseDtos(series);
    }

    @Override
    public SerieResponseDto deleteSerie(Long serieId) {

        Serie serie=getSerie(serieId);
        serieRepository.delete(serie);
        return mapper.serieParaSerieResponseDto(serie);
    }

    @Override
    public SerieResponseDto editSerie(Long serieId, SerieRequestDto serieRequestDto) {

        Serie serieParaEditar=getSerie(serieId);
        serieParaEditar.setImagen(serieRequestDto.getImagen());
        serieParaEditar.setTitulo(serieRequestDto.getTitulo());
        serieParaEditar.setFechaCreacion(serieRequestDto.getFechaCreacion());
        if (!serieRequestDto.getPersonajeIds().isEmpty()){
            List<Personaje>personajes= new ArrayList<>();
            for (Long personajeId: serieRequestDto.getPersonajeIds()){
                Personaje personaje = personajeService.getPersonaje(personajeId);
                personajes.add(personaje);
            }
            serieParaEditar.setPersonajes(personajes);
        }
        if (serieRequestDto.getGeneroId()!=null){
            Genero genero = generoService.getGenero(serieRequestDto.getGeneroId());
            serieParaEditar.setGenero(genero);
        }


        return mapper.serieParaSerieResponseDto(serieParaEditar);
    }

    @Override
    public SerieResponseDto addPersonajeToSerie(Long serieId, Long personajeId) {

        Serie serie = getSerie(serieId);
        Personaje personaje = personajeService.getPersonaje(personajeId);
        if (personaje.getSeries().contains(personaje)){
            throw new IllegalArgumentException("El personaje ya esta asignado a la serie");
        }
        serie.addPersonaje(personaje);
        personaje.addSerie(serie);
        return mapper.serieParaSerieResponseDto(serie);
    }

    @Override
    public SerieResponseDto deletePersonajeFromSerie(Long serieId, Long personajeId) {
        Serie   serie = getSerie(serieId);
        Personaje personaje = personajeService.getPersonaje(personajeId);
        if (!personaje.getSeries().contains(serie)){
            throw new IllegalArgumentException("La serie no contiene este  personaje");
        }
        personaje.removeSerie(serie);
        serie.deletePersonaje(personaje);

        return mapper.serieParaSerieResponseDto(serie);
    }

    @Override
    public SerieResponseDto addGeneroToSerie(Long serieId, Long generoId) {
        Serie serie = getSerie(serieId);
        Genero genero = generoService.getGenero(generoId);
        if (Objects.nonNull(serie.getGenero())){
            throw new IllegalArgumentException("La serie ya tiene genero");
        }
        serie.setGenero(genero);
        genero.addSerie(serie);

        return mapper.serieParaSerieResponseDto(serie);
    }
}
