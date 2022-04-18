package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service;


import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Genero;
import org.springframework.stereotype.Service;

@Service
public interface GeneroService {

    public Genero getGenero(Long generoId);
}
