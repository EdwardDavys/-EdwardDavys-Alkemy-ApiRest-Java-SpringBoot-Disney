package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.controller;


import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.GeneroRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.GeneroResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service.GeneroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping("/add")
    public ResponseEntity<GeneroResponseDto> addGenero(@RequestBody GeneroRequestDto generoRequestDto){
        GeneroResponseDto generoResponseDto = generoService.addGenero(generoRequestDto);
        return new ResponseEntity<>(generoResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get{id}")
    public ResponseEntity<GeneroResponseDto> getGenero(@PathVariable final Long id){
        GeneroResponseDto generoResponseDto = generoService.getGeneroById(id);
        return  new ResponseEntity<>(generoResponseDto,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GeneroResponseDto>> getGeneros(){
        List<GeneroResponseDto>generoResponseDtos = generoService.getGeneros();
        return new ResponseEntity<>(generoResponseDtos,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneroResponseDto> deleteGenero(@PathVariable final Long id){
        GeneroResponseDto generoResponseDto = generoService.deleteGenero(id);
        return new ResponseEntity<>(generoResponseDto,HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<GeneroResponseDto> editGenero(@PathVariable final Long id, @RequestBody GeneroRequestDto generoRequestDto){
        GeneroResponseDto generoResponseDto = generoService.editGenero(id,generoRequestDto);
        return new ResponseEntity<>(generoResponseDto,HttpStatus.OK);
    }
}
