package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
