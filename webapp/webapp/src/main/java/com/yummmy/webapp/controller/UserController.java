package com.yummmy.webapp.controller;

import com.yummmy.webapp.entity.User;
import com.yummmy.webapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Afficher la page d'inscription

    @GetMapping("/user/register")
    public String getRegister(Model model){
        model.addAttribute("registerRequest", new User());
        model.addAttribute("isRestaurateur", false);
        return "pages/register";
    }

    //Ajouter un utilisateur

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute User user) {
        User registeredUser = userService.registerUser(user.getEmail(), user.getPassword(), user.getSurname(), user.getName(), user.getPhone(), user.isRestaurateur());
        return registeredUser == null ? "error_page" : "redirect:/user/login";
    }

    //Afficher la page login

    @GetMapping("/user/login")
    public String getLogin(Model model){
        model.addAttribute("loginRequest", new User());
        return "pages/login";
    }


    @PostMapping("/user/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User authenticated = userService.authenticate(user.getEmail(), user.getPassword());
        if(authenticated !=null){
            model.addAttribute("name", authenticated.getName());
            model.addAttribute("surname", authenticated.getSurname());
            model.addAttribute("email", authenticated.getEmail());
            model.addAttribute("phone", authenticated.getPhone());
            return "/pages/account";
        }else{
            return "/pages/login";
        }
    }

    //Afficher la page compte

    @GetMapping("/user/account")
    public String getAccount(){
        return "pages/account";
    }

}

