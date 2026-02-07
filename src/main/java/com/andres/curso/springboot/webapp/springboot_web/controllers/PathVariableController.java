package com.andres.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springboot_web.models.ParamDto;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {

//Anotación @PathVariable

@GetMapping("/baz/{mensaje}")
public ParamDto baz(@PathVariable String mensaje) {

    ParamDto paramDto = new ParamDto();
    paramDto.setMensaje(mensaje);
    return paramDto;
}
//http://localhost:8080/api/var/baz/mesa
    


@GetMapping("/mix/{product}/{id}")
public Map<String, Object> getMethodName(@PathVariable String product, @PathVariable long id) {

    Map<String, Object > json  = new HashMap<>();
    json.put("product", product);
    json.put("id", id);

    return json;
}

//http://localhost:8080/api/var/mix/telefono/003


}






