package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.responseDto;

public class PersonajeResponseFilterDto {

    private Long id;
    private String imagen;
    private String nombre;

    public PersonajeResponseFilterDto() {
    }

    public PersonajeResponseFilterDto(Long id, String imagen, String nombre) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
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
}
