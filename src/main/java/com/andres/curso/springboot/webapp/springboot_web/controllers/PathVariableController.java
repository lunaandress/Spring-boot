package com.andres.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springboot_web.models.ParamDto;
import com.andres.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // ===============================
    // INYECCIÓN DESDE values.properties
    // ===============================

    @Value("${config.name}")
    private String name;

    @Value("${config.code}")
    private Integer code;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> valuesString;

    @Value("#{${config.valuesMap}}")
    private Map<String ,Object>valuesMap;

    // ===============================
    // PATH VARIABLES de producto
    // ===============================

    @Value("#{${config.valuesMap}['product']}")
    private String product;

    @Value("#{${config.valuesMap}['descripcion']}")
    private String descripcion;

    @Value("#{${config.valuesMap}['price']}")
    private String price;

    // Objeto Environment de Spring para leer configuraciones
    @Autowired
    private Environment environment;

    

    // ===============================
    // PATH VARIABLES
    // ===============================

    @GetMapping("/baz/{mensaje}")
    public ParamDto baz(@PathVariable String mensaje) {

        ParamDto paramDto = new ParamDto();
        paramDto.setMensaje(mensaje);
        return paramDto;
    }

    // http://localhost:8080/api/var/baz/mesa

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mix(
            @PathVariable String product,
            @PathVariable long id) {

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    // http://localhost:8080/api/var/mix/telefono/3

    // ===============================
    // POST JSON
    // ===============================

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return user;
    }

    // ===============================
    // LEER VALUES.PROPERTIES
    // ===============================

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message   ) {

        Map<String, Object> json = new HashMap<>();

        json.put("name", name);
        json.put("code", code);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", environment.getProperty("config.code"));
        json.put("listOfValues", listOfValues);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);


        return json;
    }

    // http://localhost:8080/api/var/values





}
