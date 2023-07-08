package com.yummmy.webapp.controller;

import com.yummmy.webapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/")
    public String index( Model model){
        model.addAttribute("listRest", restaurantService.getRestaurants());
        return "pages/index";
    }


}
