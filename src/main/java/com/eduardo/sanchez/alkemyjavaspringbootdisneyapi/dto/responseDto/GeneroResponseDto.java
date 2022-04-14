package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto;

import java.util.List;

public class GeneroResponseDto {

    private Long id;
    private String nombre;
    private List<String> nombreSerie;

    public GeneroResponseDto() {
    }

    public GeneroResponseDto(Long id, String nombre, List<String> nombreSerie) {
        this.id = id;
        this.nombre = nombre;
        this.nombreSerie = nombreSerie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getNombreSerie() {
        return nombreSerie;
    }

    public void setNombreSerie(List<String> nombreSerie) {
        this.nombreSerie = nombreSerie;
    }
}
