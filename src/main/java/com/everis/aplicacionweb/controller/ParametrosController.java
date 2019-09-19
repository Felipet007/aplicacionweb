package com.everis.aplicacionweb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "Basicos")
public class ParametrosController {

    @ApiOperation(value = "Get the name of user", notes="Return the name of the request. Simple and basic")
    @ResponseBody
    @RequestMapping(value="/miNombre", method = RequestMethod.GET)
    public String miNombre(@RequestParam(name="nombre", defaultValue = "un anònim de la vida") String nom){
        return "Soc " + nom;
    }

    //PARAMETROS
    @ResponseBody
    @RequestMapping(value="/misNombres", method = {RequestMethod.GET,RequestMethod.POST})
    public String misNombres(@RequestParam Map<String,String> mapa){
        return sacarListaComoHtml(mapa);
    }

    //PARAMETROS EN PATH
    @ResponseBody
    @RequestMapping(value = "/misCosas/{cosa}/{color}", method = RequestMethod.GET)
    public String miCosa(@PathVariable("cosa") String cosa, @PathVariable(value = "color", required = false) String color){
        return cosa + " - " + color;
    }

    public String sacarListaComoHtml(Map<String,String> mapa){

        String html = "<h1>Paràmetres</h1></br><ul>";

        for(String key: mapa.keySet()){
            html = html + "<li>" + key + " - " + mapa.get(key) + "</li>";
        }

        html = html + "</ul>";

        return html;
    }
}
