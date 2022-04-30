package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.PersonajeResponseFilterDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {


}
