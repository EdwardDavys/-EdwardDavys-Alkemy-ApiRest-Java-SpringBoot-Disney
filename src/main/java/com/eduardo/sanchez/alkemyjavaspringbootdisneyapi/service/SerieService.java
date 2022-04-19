package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.SerieRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.SerieResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Serie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SerieService {

    public SerieResponseDto addSerie(SerieRequestDto serieRequestDto);
    public SerieResponseDto getSerieById(Long serieId);
    public Serie getSerie (Long serieId);
    public List<SerieResponseDto> getSeries();
    public SerieResponseDto deleteSerie(Long serieId);
    public SerieResponseDto editSerie(Long serieId, SerieRequestDto serieRequestDto);
    public SerieResponseDto addPersonajeToSerie(Long serieId, Long personajeId);
    public SerieResponseDto deletePersonajeFromSerie(Long serieId, Long personajeId);
    public SerieResponseDto addGeneroToSerie(Long serieId, Long generoId);



}
