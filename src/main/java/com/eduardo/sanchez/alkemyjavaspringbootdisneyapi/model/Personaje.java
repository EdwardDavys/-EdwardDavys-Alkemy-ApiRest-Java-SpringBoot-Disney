package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.model;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;

    @ManyToMany(mappedBy = "genero",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Serie> series= new ArrayList<>();

    public Personaje() {
    }

    public Personaje(String imagen, String nombre, int edad, int peso, String historia, List<Serie> series) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.series = series;
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

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public void addSerie(Serie serie){
        series.add(serie);
    }

    public void removeSerie(Serie serie){
        series.remove(serie);
    }
}
