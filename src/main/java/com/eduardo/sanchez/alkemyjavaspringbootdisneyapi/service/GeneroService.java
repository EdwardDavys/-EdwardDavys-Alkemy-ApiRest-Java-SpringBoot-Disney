package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service;


import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.GeneroRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.GeneroResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Genero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GeneroService {

    public Genero getGenero(Long generoId);
    public GeneroResponseDto addGenero(GeneroRequestDto generoRequestDto);
    public GeneroResponseDto getGeneroById(Long generoId);
    public List<GeneroResponseDto> getGeneros();
    public GeneroResponseDto deleteGenero(Long generoId);
    public GeneroResponseDto editGenero(Long generoId, GeneroRequestDto generoRequestDto);
}
