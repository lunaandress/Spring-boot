package com.andres.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springboot_web.models.ParamDto;



@RestController
@RequestMapping("/api/params")
public class RequestParamsController {


    @GetMapping("foo")
    public ParamDto foo(@RequestParam String mensaje) {

        ParamDto  param  = new ParamDto();
        param.setMensaje(mensaje);
        
        return param;
    }
    
        // http://localhost:8080/api/params/foo?mensaje=hola%20andres
    
}
