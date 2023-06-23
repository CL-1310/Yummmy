package com.yummmy.webapp.controller;

import com.yummmy.webapp.entity.User;
import com.yummmy.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    //    OBTENIR UN UTILISATEUR PAR SON ID

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    //    OBTENIR UN UTILISATEUR PAR SON NOM

    @GetMapping("/user/{name}")
    public User findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    //    METTRE A JOUR UN UTILISATEUR

    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    //    SUPPRIMER UN UTILISATEUR

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login_page";
    }
}


