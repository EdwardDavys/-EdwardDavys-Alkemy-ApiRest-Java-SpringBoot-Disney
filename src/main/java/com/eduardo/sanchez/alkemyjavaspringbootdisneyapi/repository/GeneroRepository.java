package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
