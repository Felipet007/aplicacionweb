package com.everis.aplicacionweb.controller;

import com.everis.aplicacionweb.model.Alumno;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.RequestHandler;

@RestController
@Api(tags = "Basicos")
public class JSONController {

    @RequestMapping(value = "/alumnos", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Alumno>[] arraitify(){

        Alumno alu = new Alumno("Felip","26",8);
        Alumno alu2 = new Alumno("Ana", "23", 9);
        Alumno alu3 = new Alumno("Claudio", "22", 4);

        ResponseEntity<Alumno>[] coleccion = new ResponseEntity[3];

        coleccion[0] = ResponseEntity.ok(alu);
        coleccion[1] = ResponseEntity.ok(alu2);
        coleccion[2] = ResponseEntity.ok(alu3);

        coleccion[0] = coleccion[0]
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(alu);


        return coleccion;
    }

    @RequestMapping(value = "/alumno", method = RequestMethod.GET)
    public Alumno objectify(){
        Alumno alu = new Alumno("Jesus", "22", 9);
        return alu;
    }

    @RequestMapping(value = "/alumno/{nom}", method = RequestMethod.GET)
    public Alumno creator(@PathVariable("nom") String nom, @RequestParam("edat") String edat, @RequestParam("nota") int nota){
        Alumno alu = new Alumno(nom,edat,nota);
        return alu;
    }

    //STRING ES EL UNICO TIPO QUE NO SE PARSEA AUTOMATICAMENTE A JSON
    @RequestMapping(value = "/cadena", method = RequestMethod.GET)
    public String cadena(){
        String cadena = "Esta es una cadena";
        return cadena;
    }

    @RequestMapping(value = "/numero", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
    public int numero(){
        return 10;
    }

    @RequestMapping(value = "/eresUnFalso", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
    public boolean falso(){
        return false;
    }
}
