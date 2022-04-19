package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.mapper;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.GeneroRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.GeneroResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model.Genero;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.repository.GeneroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class GeneroServiceImpl implements GeneroService{


    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }


    @Override
    public Genero getGenero(Long generoId) {
        return generoRepository.findById(generoId).orElseThrow(()->
                new IllegalArgumentException("No se puede encontrar el Genero con Id: "+generoId));
    }

    @Override
    public GeneroResponseDto addGenero(GeneroRequestDto generoRequestDto) {

        Genero genero = new Genero();
        genero.setNombre(generoRequestDto.getNombre());
        genero.setImagen(generoRequestDto.getImagen());
        generoRepository.save(genero);
        return mapper.generoParaGeneroResponseDto(genero);
    }

    @Override
    public GeneroResponseDto getGeneroById(Long generoId) {
        Genero genero = getGenero(generoId);
        return mapper.generoParaGeneroResponseDto(genero);
    }

    @Override
    public List<GeneroResponseDto> getGeneros() {
        List<Genero> generos = StreamSupport
                .stream(generoRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return mapper.generosParaResponseDtos(generos);
    }

    @Override
    public GeneroResponseDto deleteGenero(Long generoId) {

        Genero genero = getGenero(generoId);
        generoRepository.delete(genero);
        return mapper.generoParaGeneroResponseDto(genero);
    }

    @Transactional
    @Override
    public GeneroResponseDto editGenero(Long generoId, GeneroRequestDto generoRequestDto) {

        Genero generoParaEditar = getGenero(generoId);
        generoParaEditar.setNombre(generoRequestDto.getNombre());
        generoParaEditar.setImagen(generoRequestDto.getImagen());
        return mapper.generoParaGeneroResponseDto(generoParaEditar);


    }
}
