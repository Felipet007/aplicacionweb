package com.everis.aplicacionweb.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ErrorControllerResponse implements ErrorController {

    @Override
    public String getErrorPath(){
        return "/error";
    }

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();

        if(response.getStatus() == HttpStatus.NOT_FOUND.value()){
            modelAndView.setViewName("errorsTemplate/error-404");
        } else if (response.getStatus() == HttpStatus.FORBIDDEN.value()){
            modelAndView.setViewName("errorsTemplate/error-403");
        } else if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()){
            modelAndView.setViewName("errorsTemplate/error-500");
        } else {
            modelAndView.setViewName("errorsTemplate/error");
        }

        return modelAndView;
    }
}
