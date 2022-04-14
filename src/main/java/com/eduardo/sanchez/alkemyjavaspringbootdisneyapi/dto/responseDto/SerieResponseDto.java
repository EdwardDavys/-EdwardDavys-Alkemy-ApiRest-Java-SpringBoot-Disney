package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto;

import java.time.LocalDate;
import java.util.List;

public class SerieResponseDto {

    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;
    private int calificacion;
    private List<String> nombrePersonaje;
    private String nombreGenero;


    public SerieResponseDto() {
    }

    public SerieResponseDto(Long id, String imagen, String titulo, LocalDate fechaCreacion, int calificacion, List<String> nombrePersonaje, String nombreGenero) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.nombrePersonaje = nombrePersonaje;
        this.nombreGenero = nombreGenero;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<String> getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(List<String> nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
}
