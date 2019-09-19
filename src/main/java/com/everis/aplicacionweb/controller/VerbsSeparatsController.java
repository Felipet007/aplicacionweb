package com.everis.aplicacionweb.controller;

import com.everis.aplicacionweb.model.Alumno;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VerbsSeparatsController {

    private static List<Alumno> lista = initialiseList();

    @GetMapping(value = "/verb", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Alumno> getAlumne(){
        return lista;
    }

    @PostMapping(value = "/verb")
    public String postAlumne(){
        lista.add(new Alumno("Felip", "26", 3));
        return "<h1>Added</h1>";
    }

    @DeleteMapping(value = "/verb")
    public String deleteAlumne(){

        if(lista.isEmpty()){
            return "<h1>List is alredy empty</h1>";
        } else {
            lista.remove(0);
            return "<h1>Deleted</h1>";
        }
    }

    private static List<Alumno> initialiseList(){

        List<Alumno> list = new ArrayList<Alumno>();
        list.add(new Alumno("Claudio","22", 9));
        list.add(new Alumno("Ana","23", 8));

        return list;
    }
}
