package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto;

import java.util.Date;

public class SerieResponseFilterDto {

    private Long id;
    private String titulo;
    private String imagen;
    private Date fechaCreacion;

    public SerieResponseFilterDto() {
    }

    public SerieResponseFilterDto(Long id, String titulo, String imagen, Date fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
