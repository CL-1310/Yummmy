package com.yummmy.webapp.controller;

import com.yummmy.webapp.entity.Dish;
import com.yummmy.webapp.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DishController {

    @Autowired
    private DishService service;

    //    AJOUTER UN PLAT
    @PostMapping("/addDish")
    public Dish addDis(@RequestBody Dish dish){
        return service.saveDish(dish);
    }

    //    OBTENIR TOUS LES PLATS

    @GetMapping("/dishes")
    public List<Dish> findAllDishes(){
        return service.getDishes();
    }

    //    OBTENIR UN PLAT PAR SON ID

    @GetMapping("/dish/{id}")
    public Dish findDishById(@PathVariable int id){
        return service.getDishById(id);
    }

    //    OBTENIR UN PLAT PAR SON NOM

    @GetMapping("/dish/{name}")
    public Dish findDishByName(@PathVariable String name) {
        return service.getDishByName(name);
    }

    //    METTRE A JOUR UN PLAT

    @PutMapping("/updatedish")
    public Dish updateDish(@RequestBody Dish dish){

        return service.updateDish(dish);
    }

    //    SUPPRIMER UN PLAT

    @DeleteMapping("/deletedish/{id}")
    public String deleteDish(@PathVariable int id){

        return service.deleteDish(id);
    }


}
