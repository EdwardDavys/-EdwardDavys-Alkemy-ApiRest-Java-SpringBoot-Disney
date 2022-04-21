package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.requestDto;



import java.util.Date;
import java.util.List;

public class SerieRequestDto {

    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    private int calificacion;
    private List<Long> personajeIds;
    private Long generoId;

    public SerieRequestDto() {
    }

    public SerieRequestDto(String imagen, String titulo, Date fechaCreacion, int calificacion, List<Long> personajeIds, Long generoId) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajeIds = personajeIds;
        this.generoId = generoId;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<Long> getPersonajeIds() {
        return personajeIds;
    }

    public void setPersonajeIds(List<Long> personajeIds) {
        this.personajeIds = personajeIds;
    }

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }
}
