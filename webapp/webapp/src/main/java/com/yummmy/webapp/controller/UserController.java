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

    //    AJOUTER UN UTILISATEUR

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

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
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("register request:" + user);
        User registeredUser = service.registerUser(user.getEmail(), user.getPassword(), user.getSurname(), user.getName(), user.getPhone(), user.isRestaurateur());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("login request:" + user);
        User authenticated = service.authenticate(user.getEmail(), user.getPassword());
        if(authenticated != null) {
            model.addAttribute("userLogin", authenticated.getName());
            return "personal_page";
        }else {
            return "error_page";
        }
    }
}
