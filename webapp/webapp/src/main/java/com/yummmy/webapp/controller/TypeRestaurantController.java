package com.yummmy.webapp.controller;

import com.yummmy.webapp.entity.TypeRestaurant;
import org.springframework.web.bind.annotation.RestController;
import com.yummmy.webapp.service.TypeRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeRestaurantController {
    @Autowired
    private TypeRestaurantService service;

    //    AJOUTER UN TYPE DE RESTAURANT

    @PostMapping("/addTypeRestaurant")
    public TypeRestaurant addTypeRestaurant(@RequestBody TypeRestaurant typeRestaurant) {
        return service.saveTypeRestaurant(typeRestaurant);
    }

    //    OBTENIR TOUS LES TYPES DE RESTAURANTS

    @GetMapping("/typeRestaurants")
    public List<TypeRestaurant> findAllTypeRestaurants() {
        return service.getTypeRestaurants();
    }

    //    OBTENIR UN TYPE DE RESTAURANT PAR SON ID

    @GetMapping("/typeRestaurant/{id}")
    public TypeRestaurant findTypeRestaurantById(@PathVariable int id){
        return service.getTypeRestaurantById(id);
    }

    //    OBTENIR UN TYPE DE RESTAURANT PAR SON NOM

    @GetMapping("/typeRestaurant/{name}")
    public TypeRestaurant findTypeRestaurantByName(@PathVariable String name){
        return service.getTypeRestaurantByName(name);
    }

    //    METTRE A JOUR UN TYPE DE RESTAURANT

    @PutMapping("/updatetyperestaurant")
    private TypeRestaurant updateTypeRestaurant(@RequestBody TypeRestaurant typeRestaurant){
        return service.updateTypeRestaurant(typeRestaurant);
    }

    //    SUPPRIMER UN TYPE DE RESTAURANT

    @DeleteMapping("/deletetyperestaurant/{id}")
    public String deleteTypeRestaurant(@PathVariable int id){
        return service.deleteTypeRestaurant(id);
    }

}
