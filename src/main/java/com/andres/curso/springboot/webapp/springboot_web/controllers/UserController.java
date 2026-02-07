package com.andres.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.andres.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    //METODO MODEL

    @GetMapping("/details")
    public String details (Model model) {

        User user = new User("Andres", "Luna");
        model.addAttribute("title","Hola Mundo Spring Booot");
        model.addAttribute("user",user);
        user.setEmail("andresluna96@gmail.com");
        return "details";

    }


    @GetMapping("/list")
    public String list(ModelMap model) {

        User us1 = new User("paco ","salas","miosesfreddy123@gmail.com");
        User us2 = new User("paquita ","salas");
        User us3 = new User("pacoyo ","salas");
        User us4 = new User("pacolines ","salas");
        User us5 = new User("pacondria ","salas");

        List<User> users = new ArrayList<>();
        
            users.add(us1);
            users.add(us2);
            users.add(us3);
            users.add(us4);
            users.add(us5);

        model.addAttribute("users", users);
        model.addAttribute("title", "listado de usarios");

        return "list";
    }
    

}
