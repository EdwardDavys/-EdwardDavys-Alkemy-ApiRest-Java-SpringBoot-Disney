package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.mapper;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.PersonajeRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.PersonajeResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Personaje;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository.PersonajeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class PersonajeServiceImpl implements PersonajeService{

    private final PersonajeRepository personajeRepository;

    public PersonajeServiceImpl(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Transactional
    @Override
    public PersonajeResponseDto addPersonaje(PersonajeRequestDto personajeRequestDto) {
        Personaje personaje = new Personaje();
        personaje.setImagen(personajeRequestDto.getImagen());
        personaje.setNombre(personajeRequestDto.getNombre());
        personaje.setEdad(personajeRequestDto.getEdad());
        personaje.setPeso(personajeRequestDto.getPeso());
        personaje.setHistoria(personajeRequestDto.getHistoria());

        personajeRepository.save(personaje);

        return mapper.personajeResponseDto(personaje);
    }

    @Override
    public List<PersonajeResponseDto> getPersonajes() {

        List<Personaje> personajes = StreamSupport
                                    .stream(personajeRepository.findAll().spliterator(),false)
                                    .collect(Collectors.toList());
        return mapper.personajesParaResponseDtos(personajes);
    }

    @Override
    public PersonajeResponseDto getPersonajeById(Long personajeId) {
        return mapper.personajeResponseDto(getPersonaje(personajeId));
    }

    @Override
    public Personaje getPersonaje(Long personajeId) {

        Personaje personaje = personajeRepository.findById(personajeId).orElseThrow(()->
                                new IllegalArgumentException(
                                        "Personaje con el id "+personajeId+" no se encontro"
                                ));
        return personaje;
    }

    @Override
    public PersonajeResponseDto deletePersonaje(Long personajeId) {

        Personaje personaje = getPersonaje(personajeId);
        personajeRepository.delete(personaje);
        return mapper.personajeResponseDto(personaje);
    }

    @Transactional
    @Override
    public PersonajeResponseDto editPersonaje(Long personajeId, PersonajeRequestDto personajeRequestDto) {

        Personaje personajeEditar=getPersonaje(personajeId);
        personajeEditar.setImagen(personajeRequestDto.getImagen());
        personajeEditar.setNombre(personajeRequestDto.getNombre());
        personajeEditar.setEdad(personajeRequestDto.getEdad());
        personajeEditar.setPeso(personajeRequestDto.getPeso());
        personajeEditar.setHistoria(personajeRequestDto.getHistoria());


        return mapper.personajeResponseDto(personajeEditar);
    }
}
