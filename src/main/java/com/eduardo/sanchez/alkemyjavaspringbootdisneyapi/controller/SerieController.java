package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.controller;


import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.SerieRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.SerieResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.SerieResponseFilterDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping("/add")
    public ResponseEntity<SerieResponseDto> addSerie(@RequestBody final SerieRequestDto serieRequestDto){
        SerieResponseDto serieResponseDto = serieService.addSerie(serieRequestDto);
        return new ResponseEntity<>(serieResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SerieResponseDto> getSerie(@PathVariable final Long id){
        SerieResponseDto serieResponseDto = serieService.getSerieById(id);
        return new ResponseEntity<>(serieResponseDto,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAll")
    public  ResponseEntity<List<SerieResponseDto>> getSeries(){
        List<SerieResponseDto> serieResponseDtos = serieService.getSeries();
        return new ResponseEntity<>(serieResponseDtos,HttpStatus.OK);
    }

    @GetMapping("/serie/{name}")
    public ResponseEntity<List<SerieResponseFilterDto>> getSerieByNombre(@PathVariable String name){
        List<SerieResponseFilterDto> serieResponseFilterDtos = serieService.getSerieBynombre(name);
        return new ResponseEntity<>(serieResponseFilterDtos, HttpStatus.OK);
    }

    @GetMapping("/{idGenero}")
    public ResponseEntity<List<SerieResponseFilterDto>> getSerieByIdGenero(@PathVariable Long idGenero){
        List<SerieResponseFilterDto> serieResponseFilterDtos = serieService.getSerieByGenero(idGenero);
        return new ResponseEntity<>(serieResponseFilterDtos,HttpStatus.OK);
    }

    @GetMapping("/ASC")
    public ResponseEntity<List<SerieResponseFilterDto>> getSerieByFechaCreacionAsc(){
        List<SerieResponseFilterDto>serieResponseFilterDtos = serieService.getOrderByFechaCreacionAsc();
        return new ResponseEntity<>(serieResponseFilterDtos, HttpStatus.OK);
    }

    @GetMapping("/DESC")
    public ResponseEntity<List<SerieResponseFilterDto>> getSerieByFechaCreacionDesc(){
        List<SerieResponseFilterDto>serieResponseFilterDtos = serieService.getOrderByFechaCreacionDesc();
        return new ResponseEntity<>(serieResponseFilterDtos, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SerieResponseDto> deleteSerie(@PathVariable final Long id){
        SerieResponseDto serieResponseDto = serieService.deleteSerie(id);
        return new ResponseEntity<>(serieResponseDto,HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<SerieResponseDto> editSerie(@PathVariable final Long id, @RequestBody final SerieRequestDto serieRequestDto){
        SerieResponseDto  serieResponseDto = serieService.editSerie(id,serieRequestDto);
        return new ResponseEntity<>(serieResponseDto, HttpStatus.OK);

    }

    @PostMapping("/addGenero/{serieId}/to/{generoId}")
    public ResponseEntity<SerieResponseDto> addGenero(@PathVariable final Long serieId, @PathVariable final Long generoId ){
        SerieResponseDto serieResponseDto = serieService.addGeneroToSerie(serieId,generoId);
        return  new ResponseEntity<>(serieResponseDto,HttpStatus.OK);

    }

    @PostMapping("/series/{serieId}/characters/{personajeId}")
    public ResponseEntity<SerieResponseDto> addPersonaje(@PathVariable final Long serieId, @PathVariable final Long personajeId){
        SerieResponseDto serieResponseDto = serieService.addPersonajeToSerie(serieId,personajeId);
        return new ResponseEntity<>(serieResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/series/{serieId}/characters/{personajeId}")
    public ResponseEntity<SerieResponseDto> removePersonaje(@PathVariable final Long serieId, @PathVariable final Long personajeId){
        SerieResponseDto serieResponseDto = serieService.deletePersonajeFromSerie(serieId,personajeId);
        return new ResponseEntity<>(serieResponseDto,HttpStatus.OK);
    }
}
