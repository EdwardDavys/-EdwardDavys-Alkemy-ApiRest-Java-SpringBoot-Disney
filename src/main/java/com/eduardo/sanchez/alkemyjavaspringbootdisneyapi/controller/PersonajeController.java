package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.controller;


import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto.PersonajeRequestDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.PersonajeResponseDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto.PersonajeResponseFilterDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class PersonajeController {

    private  final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @PostMapping("/add")
    public ResponseEntity<PersonajeResponseDto> addPersonaje(@RequestBody  final PersonajeRequestDto personajeRequestDto){
        PersonajeResponseDto personajeResponseDto = personajeService.addPersonaje(personajeRequestDto);
        return new ResponseEntity<>(personajeResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PersonajeResponseDto> getPersonaje(@PathVariable final Long id){
        PersonajeResponseDto personajeResponseDto = personajeService.getPersonajeById(id);
        return new ResponseEntity<>(personajeResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PersonajeResponseDto>> getPersonajes(){
        List<PersonajeResponseDto> personajeResponseDtos = personajeService.getPersonajes();
        return new ResponseEntity<>(personajeResponseDtos,HttpStatus.OK);

    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<List<PersonajeResponseFilterDto>> getPersonajeByNombre(@PathVariable String name){
        List<PersonajeResponseFilterDto> personajeResponseFilterDtos = personajeService.findByNombre(name);
        return new ResponseEntity<>(personajeResponseFilterDtos, HttpStatus.OK);
    }

   /* @GetMapping("/serie/{idSerie}")
    public ResponseEntity<List<PersonajeResponseFilterDto>> getPersonajeBySerieid(@PathVariable Long idSerie){
        List<PersonajeResponseFilterDto> personajeResponseFilterDtos = personajeService.findBySeries(idSerie);
        return new ResponseEntity<>(personajeResponseFilterDtos, HttpStatus.OK);
    }*/

    @GetMapping("/edad/{age}")
    public ResponseEntity<List<PersonajeResponseFilterDto>> getPersonajeByEdad(@PathVariable int age){
        List<PersonajeResponseFilterDto> personajeResponseFilterDtos = personajeService.findByEdad(age);
        return new ResponseEntity<>(personajeResponseFilterDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PersonajeResponseDto> deletePersonaje(@PathVariable final Long id){
        PersonajeResponseDto personajeResponseDto = personajeService.deletePersonaje(id);
        return new ResponseEntity<>(personajeResponseDto,HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<PersonajeResponseDto> editPersonaje(@PathVariable final Long id, final PersonajeRequestDto personajeRequestDto){
        PersonajeResponseDto personajeResponseDto = personajeService.editPersonaje(id,personajeRequestDto);
        return new ResponseEntity<>(personajeResponseDto, HttpStatus.OK);
    }
}
