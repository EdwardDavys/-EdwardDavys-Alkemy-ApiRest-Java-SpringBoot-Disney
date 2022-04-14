package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto;

import java.util.List;

public class PersonajeRequestDto {

    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;
    private List<Long> serieIds;

    public PersonajeRequestDto() {
    }

    public PersonajeRequestDto(String imagen, String nombre, int edad, int peso, String historia, List<Long> serieIds) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.serieIds = serieIds;
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

    public List<Long> getSerieIds() {
        return serieIds;
    }

    public void setSerieIds(List<Long> serieIds) {
        this.serieIds = serieIds;
    }
}
