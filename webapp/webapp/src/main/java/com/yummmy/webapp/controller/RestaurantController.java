package com.yummmy.webapp.controller;

import com.yummmy.webapp.entity.Restaurant;
import com.yummmy.webapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    //    AJOUTER UN RESTAURANT

    @PostMapping("/addRestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return service.saveRestaurant(restaurant);
    }

    //    OBTENIR TOUS LES RESTAURANTS

    @GetMapping("/restaurants")
    public List<Restaurant> findAllRestaurants() {
        return service.getRestaurants();
    }

    //    OBTENIR UN RESTAURANT PAR SON ID

    @GetMapping("/restaurant/{id}")
    public Restaurant findRestaurantById(@PathVariable int id){
        return service.getRestaurantById(id);
    }

    //    OBTENIR UN RESTAURANT PAR SON NOM

    @GetMapping("/restaurant/{name}")
    public Restaurant findRestaurantbyName(@PathVariable String name){
        return service.getRestaurantByName(name);
    }

    //    METTRE A JOUR UN RESTAURANT

    @PutMapping("/updaterestaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return  service.updateRestaurant(restaurant);
    }

    @DeleteMapping("/deleterestaurant/{id}")
    public String deleteRestaurant(@PathVariable int id) {
        return service.deleteRestaurant(id);
    }

}
