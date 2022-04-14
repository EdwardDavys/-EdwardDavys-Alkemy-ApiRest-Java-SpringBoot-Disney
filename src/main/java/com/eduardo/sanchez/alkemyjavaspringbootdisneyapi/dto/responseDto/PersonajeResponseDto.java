package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto;

import java.util.List;

public class PersonajeResponseDto {

    private Long id;
    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;
    private List<String> seriesName;

    public PersonajeResponseDto() {
    }

    public PersonajeResponseDto(Long id, String imagen, String nombre, int edad, int peso, String historia, List<String> seriesName) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.seriesName = seriesName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<String> getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(List<String> seriesName) {
        this.seriesName = seriesName;
    }
}
