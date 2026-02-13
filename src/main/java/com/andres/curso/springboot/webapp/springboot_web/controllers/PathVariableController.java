package com.andres.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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


    //INYECTAMOS LO DEL PROPETIES A LAS VARIBLES como atributos 

    @Value("${config.name}")
    private String name;
    @Value("${config.code}")
   // private String code;
   //@Value("${config.message}")
    private String message;
    @Value("${config.listOfValues}")
    private String[] listOfValues;

    //METODOS CONTROLADORES

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

    //http://localhost:8080/api/var/mix/telefono/003

}


// Api Rest enviar Json petición POST

    @PostMapping("/create")
    public User creatUser(@RequestBody User user) {
    
        return user;
    }
    

    //Inyectar valores usando la anotación @Value
        //INYECTAMOS LO DEL PROPETIES A LAS VARIBLES como  parametros
    @GetMapping("/values")
    public Map<String ,Object> values(@Value("${config.message}") String code) {

        Map<String,Object> json =new HashMap<>();
        json.put("name", name);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);

        return json ;
    }
    
    


}









