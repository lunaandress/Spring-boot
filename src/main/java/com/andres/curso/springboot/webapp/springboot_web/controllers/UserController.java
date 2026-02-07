package com.andres.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.andres.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    //METODO MODEL


    //path
    @GetMapping("/details")
    public String details (Model model) {

        User user = new User("Andres", "Luna");
        model.addAttribute("title","Hola Mundo Spring Booot");
        model.addAttribute("user",user);
        user.setEmail("andresluna96@gmail.com");
        return "details";

    }


    //path
    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "listado de usarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User>usuarioModel(){

    List<User> users = Arrays.asList(
        new User("andres" , "luna"),
        new User("andras" , "luna"),
        new User("andrea" , "luna")
    );
        return users ;
    }
    

}
