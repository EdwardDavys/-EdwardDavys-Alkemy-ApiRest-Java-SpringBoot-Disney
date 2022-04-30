package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonajeRepository extends JpaRepository<Personaje,Long> {

    List<Personaje> findByNombre(String nombre);
    List<Personaje> findByEdad(int edad);
   // List<Personaje> findBySeries(Long idSerie);
}
