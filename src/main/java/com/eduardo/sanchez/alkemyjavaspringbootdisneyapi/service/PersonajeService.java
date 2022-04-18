package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.PersonajeRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.PersonajeResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonajeService {

    public PersonajeResponseDto addPersonaje(PersonajeRequestDto personajeRequestDto);
    public List<PersonajeResponseDto> getPersonajes();
    public PersonajeResponseDto getPersonajeById(Long personajeId);
    public Personaje getPersonaje(Long personajeId);
    public PersonajeResponseDto deletePersonaje(Long personajeId);
    public PersonajeResponseDto editPersonaje(Long personajeId, PersonajeRequestDto personajeRequestDto);



}
