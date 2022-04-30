package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findByTitulo(String titulo);
    List<Serie> OrderByFechaCreacionAsc();
    List<Serie> OrderByFechaCreacionDesc();

}
