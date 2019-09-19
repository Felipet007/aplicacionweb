package com.everis.aplicacionweb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alumno {

    private String nombre;
    private String edad;
    private int notaMedia;

    public Alumno(String nom, String ed, int nota){
        nombre = nom;
        edad = ed;
        notaMedia = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(int notaMedia) {
        this.notaMedia = notaMedia;
    }
}
