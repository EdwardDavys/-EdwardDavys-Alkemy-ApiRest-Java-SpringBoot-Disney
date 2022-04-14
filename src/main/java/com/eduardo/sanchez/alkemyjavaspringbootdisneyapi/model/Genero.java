package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String imagen;
    @OneToMany(mappedBy = "genero",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Serie>series=new ArrayList<>();

    public Genero() {
    }

    public Genero(String nombre, String imagen, List<Serie> series) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.series = series;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
