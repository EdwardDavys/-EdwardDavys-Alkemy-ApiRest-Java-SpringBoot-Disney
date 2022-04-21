package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.GeneroResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.PersonajeResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.SerieResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Genero;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Personaje;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Serie;


import java.util.ArrayList;
import java.util.List;

public class mapper {

    public static SerieResponseDto serieParaSerieResponseDto(Serie serie){

        SerieResponseDto serieResponseDto = new SerieResponseDto();
        serieResponseDto.setId(serie.getId());
        serieResponseDto.setImagen(serie.getImagen());
        serieResponseDto.setTitulo(serie.getTitulo());
        serieResponseDto.setFechaCreacion(serie.getFechaCreacion());
        serieResponseDto.setCalificacion(serie.getCalificacion());
        serieResponseDto.setNombreGenero(serie.getGenero().getNombre());
        List<String> nombres= new ArrayList<>();
        List<Personaje> personajes= serie.getPersonajes();
        for(Personaje personaje: personajes){
            nombres.add(personaje.getNombre());
        }
        serieResponseDto.setNombrePersonaje(nombres);

        return serieResponseDto;
    }

    public static List<SerieResponseDto> seriesParaSerieResponseDtos(List<Serie> series){
          List<SerieResponseDto> serieResponseDtos=new ArrayList<>();
          for (Serie serie: series){
              serieResponseDtos.add(serieParaSerieResponseDto(serie));
          }
          return serieResponseDtos;
    }

    public static PersonajeResponseDto personajeResponseDto(Personaje personaje){
            PersonajeResponseDto personajeResponseDto = new PersonajeResponseDto();
            personajeResponseDto.setId(personaje.getId());
            personajeResponseDto.setImagen(personaje.getImagen());
            personajeResponseDto.setNombre(personaje.getNombre());
            personajeResponseDto.setEdad(personaje.getEdad());
            personajeResponseDto.setPeso(personaje.getPeso());
            personajeResponseDto.setHistoria(personaje.getHistoria());
            List<String> nombres = new ArrayList<>();
            List<Serie> series = personaje.getSeries();
            for (Serie serie: series){
                nombres.add(serie.getTitulo());
            }
            personajeResponseDto.setSeriesName(nombres);
            return personajeResponseDto;
    }

    public static List<PersonajeResponseDto> personajesParaResponseDtos (List<Personaje> personajes){
        List<PersonajeResponseDto> personajeResponseDtos = new ArrayList<>();
        for (Personaje personaje: personajes){
            personajeResponseDtos.add(personajeResponseDto(personaje));
        }
        return personajeResponseDtos;
    }

    public static GeneroResponseDto generoParaGeneroResponseDto(Genero genero){
        GeneroResponseDto generoResponseDto = new GeneroResponseDto();
        generoResponseDto.setId(genero.getId());
        generoResponseDto.setNombre(genero.getNombre());
        List<String> nombres= new ArrayList<>();
        List<Serie> series = genero.getSeries();
        for (Serie serie: series){
            nombres.add(serie.getTitulo());
        }
        generoResponseDto.setNombreSerie(nombres);
        return generoResponseDto;
    }

    public static List<GeneroResponseDto>generosParaResponseDtos (List<Genero> generos){
        List<GeneroResponseDto> generoResponseDtos=new ArrayList<>();
        for (Genero genero:generos){
            generoResponseDtos.add(generoParaGeneroResponseDto(genero));
        }
        return generoResponseDtos;
    }

}
