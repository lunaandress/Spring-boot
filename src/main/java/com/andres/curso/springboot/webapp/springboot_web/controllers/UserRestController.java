package com.andres.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springboot_web.dto.UserDto;
import com.andres.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {


    @RequestMapping("/list")
    public List<User>list() {

        User  user1 = new User("andres", "luna");
        User  user2 = new User("juan", "castro");
        User  user3 = new User("jesus", "marino");
    
        List<User>listUsers=new ArrayList<>();
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        return listUsers;
    }



    //METODO  con clase DTO
    @GetMapping("/detailsdto") 
    public UserDto details () {
    
        UserDto userDto = new UserDto();
        User user = new User("Juan", "Guzman");
        userDto.setTitle("HOLA MAMA PINGA");
        userDto.setUser(user);
        return userDto;

    }


    //METODO MAP
    @GetMapping("/detailsmap") //ruta de de mi paguin web que me abre mi controlador
    public Map<String,Object> details2 () {


    User user = new User("Andres", "Luna");
    Map<String,Object>body= new HashMap<>();
    body.put("title","Hola Mundo Spring Booot");
    body.put("user",user);
        return body;

    }




}
